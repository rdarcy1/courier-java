/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.courier.api.resources.send.types;

import com.courier.api.core.ObjectMappers;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import java.io.IOException;
import java.util.Objects;

@JsonDeserialize(using = Recipient.Deserializer.class)
public final class Recipient {
    private final Object value;

    private final int type;

    private Recipient(Object value, int type) {
        this.value = value;
        this.type = type;
    }

    @JsonValue
    public Object get() {
        return this.value;
    }

    public <T> T visit(Visitor<T> visitor) {
        if (this.type == 0) {
            return visitor.visit((AudienceRecipient) this.value);
        } else if (this.type == 1) {
            return visitor.visit((ListRecipient) this.value);
        } else if (this.type == 2) {
            return visitor.visit((ListPatternRecipient) this.value);
        } else if (this.type == 3) {
            return visitor.visit((UserRecipient) this.value);
        } else if (this.type == 4) {
            return visitor.visit((SlackRecipient) this.value);
        } else if (this.type == 5) {
            return visitor.visit((MsTeamsRecipient) this.value);
        }
        throw new IllegalStateException("Failed to visit value. This should never happen.");
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Recipient && equalTo((Recipient) other);
    }

    private boolean equalTo(Recipient other) {
        return value.equals(other.value);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.value);
    }

    @java.lang.Override
    public String toString() {
        return this.value.toString();
    }

    public static Recipient of(AudienceRecipient value) {
        return new Recipient(value, 0);
    }

    public static Recipient of(ListRecipient value) {
        return new Recipient(value, 1);
    }

    public static Recipient of(ListPatternRecipient value) {
        return new Recipient(value, 2);
    }

    public static Recipient of(UserRecipient value) {
        return new Recipient(value, 3);
    }

    public static Recipient of(SlackRecipient value) {
        return new Recipient(value, 4);
    }

    public static Recipient of(MsTeamsRecipient value) {
        return new Recipient(value, 5);
    }

    public interface Visitor<T> {
        T visit(AudienceRecipient value);

        T visit(ListRecipient value);

        T visit(ListPatternRecipient value);

        T visit(UserRecipient value);

        T visit(SlackRecipient value);

        T visit(MsTeamsRecipient value);
    }

    static final class Deserializer extends StdDeserializer<Recipient> {
        Deserializer() {
            super(Recipient.class);
        }

        @java.lang.Override
        public Recipient deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            Object value = p.readValueAs(Object.class);
            try {
                return of(ObjectMappers.JSON_MAPPER.convertValue(value, AudienceRecipient.class));
            } catch (IllegalArgumentException e) {
            }
            try {
                return of(ObjectMappers.JSON_MAPPER.convertValue(value, ListRecipient.class));
            } catch (IllegalArgumentException e) {
            }
            try {
                return of(ObjectMappers.JSON_MAPPER.convertValue(value, ListPatternRecipient.class));
            } catch (IllegalArgumentException e) {
            }
            try {
                return of(ObjectMappers.JSON_MAPPER.convertValue(value, UserRecipient.class));
            } catch (IllegalArgumentException e) {
            }
            try {
                return of(ObjectMappers.JSON_MAPPER.convertValue(value, SlackRecipient.class));
            } catch (IllegalArgumentException e) {
            }
            try {
                return of(ObjectMappers.JSON_MAPPER.convertValue(value, MsTeamsRecipient.class));
            } catch (IllegalArgumentException e) {
            }
            throw new JsonParseException(p, "Failed to deserialize");
        }
    }
}
