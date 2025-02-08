package prog2.util;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

public abstract class ToString {
    private final static String IDENT = "  ";

    public static String fromGetters(Object obj) {
        StringBuilder sb = new StringBuilder(obj.getClass().getSimpleName() + " {\n");
        final List<String> attributes = new ArrayList<>();
        for (final Method method : obj.getClass().getMethods()) {
            if (method.getName().equals("getClass")) continue;
            final boolean isPublic = Modifier.isPublic(method.getModifiers());
            final boolean isGetter = method.getName().matches("^(get|is).*") && method.getParameterCount() == 0;
            if (isPublic && isGetter) {
                final String name = method.getName().replaceFirst("(get|is)", "");
                Type genericReturnType = method.getGenericReturnType();
                String type = determineTypeName(genericReturnType);
                final String value;
                try {
                    value = method.invoke(obj).toString();
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
                attributes.add("%s: %s = %s".formatted(name, type, value));
            }
        }
        sb.append(String.join("\n", attributes)).append('\n').append('}');
        return formatIdentation(sb.toString());
    }

    private static String determineTypeName(Type type) {
        if (type instanceof ParameterizedType pt) {
            Type rawType = pt.getRawType();
            String rawTypeName = rawType instanceof Class ? ((Class<?>) rawType).getSimpleName() : rawType.getTypeName();
            rawTypeName = rawTypeName.replaceAll("([a-zA-Z_$][a-zA-Z\\d_$]*\\.)+", "");
            Type[] typeArgs = pt.getActualTypeArguments();
            List<String> typeArgNames = new ArrayList<>();
            for (Type t : typeArgs) {
                typeArgNames.add(determineTypeName(t));
            }
            return rawTypeName + "<" + String.join(", ", typeArgNames) + ">";
        } else if (type instanceof Class) {
            return ((Class<?>) type).getSimpleName();
        } else {
            String typeName = type.getTypeName();
            return typeName.replaceAll("([a-zA-Z_$][a-zA-Z\\d_$]*\\.)+", "");
        }
    }

    public static String formatIdentation(String string) {
        int depth = 0;
        final String[] lines = string.split("\n");
        final String[] newLines = new String[lines.length];
        for (int i = 0; i < lines.length; i++) {
            final String line = lines[i];
            if (line.endsWith("}")) depth--;
            newLines[i] = IDENT.repeat(depth) + line;
            if (line.endsWith("{")) depth++;
        }
        return String.join("\n", newLines);
    }
}