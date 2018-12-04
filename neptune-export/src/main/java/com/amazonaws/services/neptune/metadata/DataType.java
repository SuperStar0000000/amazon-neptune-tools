package com.amazonaws.services.neptune.metadata;

import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.stream.Collectors;

public enum DataType {

    None {
        @Override
        public String typeDescription() {
            return "";
        }
    },
    Boolean {
        @Override
        public String typeDescription() {
            return ":bool";
        }

        @Override
        public void printTo(JsonGenerator generator, Object value) throws IOException {
            generator.writeBoolean((boolean)value);
        }

        @Override
        public void printTo(JsonGenerator generator, String key, Object value) throws IOException {
            generator.writeBooleanField(key, (boolean)value);
        }
    },
    Byte{
        @Override
        public void printTo(JsonGenerator generator, Object value) throws IOException {
            generator.writeNumber((byte)value);
        }

        @Override
        public void printTo(JsonGenerator generator, String key, Object value) throws IOException {
            generator.writeNumberField(key, (byte)value);
        }
    },
    Short{
        @Override
        public void printTo(JsonGenerator generator, Object value) throws IOException {
            generator.writeNumber((short)value);
        }

        @Override
        public void printTo(JsonGenerator generator, String key, Object value) throws IOException {
            generator.writeNumberField(key, (short)value);
        }
    },
    Integer {
        @Override
        public String typeDescription() {
            return ":int";
        }

        @Override
        public void printTo(JsonGenerator generator, Object value) throws IOException {
            generator.writeNumber((int)value);
        }

        @Override
        public void printTo(JsonGenerator generator, String key, Object value) throws IOException {
            generator.writeNumberField(key, (int)value);
        }
    },
    Long {
        @Override
        public void printTo(JsonGenerator generator, Object value) throws IOException {
            generator.writeNumber((long)value);
        }

        @Override
        public void printTo(JsonGenerator generator, String key, Object value) throws IOException {
            generator.writeNumberField(key, (long)value);
        }
    },
    Float{
        @Override
        public void printTo(JsonGenerator generator, Object value) throws IOException {
            generator.writeNumber((float)value);
        }

        @Override
        public void printTo(JsonGenerator generator, String key, Object value) throws IOException {
            generator.writeNumberField(key, (float)value);
        }
    },
    Double{
        @Override
        public void printTo(JsonGenerator generator, Object value) throws IOException {
            generator.writeNumber((double)value);
        }

        @Override
        public void printTo(JsonGenerator generator, String key, Object value) throws IOException {
            generator.writeNumberField(key, (double)value);
        }
    },
    String {
        @Override
        public String format(Object value) {
            return java.lang.String.format(
                    "\"%s\"",
                    doubleQuotes(value));
        }

        private String doubleQuotes(Object value) {
            return value.toString().replace("\"", "\"\"");
        }

        @Override
        public String formatList(Collection<?> values) {
            return java.lang.String.format("\"%s\"",
                    values.stream().
                            map(this::doubleQuotes).
                            collect(Collectors.joining(";")));
        }
    },
    Date {
        @Override
        public String format(Object value) {
            java.util.Date date = (java.util.Date) value;
            return DateTimeFormatter.ISO_INSTANT.format(date.toInstant());
        }

        @Override
        public void printTo(JsonGenerator generator, Object value) throws IOException {
            generator.writeString(format(value));
        }

        @Override
        public void printTo(JsonGenerator generator, String key, Object value) throws IOException {
            generator.writeStringField(key, format(value));
        }
    };

    public static DataType dataTypeFor(Class cls) {
        String name = cls.getSimpleName();
        try {
            return DataType.valueOf(name);
        } catch (IllegalArgumentException e) {
            return DataType.String;
        }
    }

    public static DataType getBroadestType(DataType oldType, DataType newType) {
        if (oldType == newType) {
            return newType;
        } else if (oldType == None) {
            return newType;
        } else if (oldType == Boolean){
            return String;
        } else if (oldType == String || newType == String) {
            return String;
        } else {
            if (newType.ordinal() > oldType.ordinal()) {
                return newType;
            } else {
                return oldType;
            }
        }
    }

    public String typeDescription() {
        return java.lang.String.format(":%s", name().toLowerCase());
    }

    public String format(Object value) {
        return value.toString();
    }

    public void printTo(JsonGenerator generator, Object value) throws IOException {
        generator.writeString(value.toString());
    }

    public void printTo(JsonGenerator generator, String key, Object value) throws IOException {
        generator.writeStringField(key, value.toString());
    }

    public String formatList(Collection<?> values) {
        return values.stream().map(this::format).collect(Collectors.joining(";"));
    }
}
