package ru.liugiakira.budget.domains;

/**
 * Значения
 * Используется для получения одной записи для Report из репозитория
 * @author k.yakovleva
 */
public class Values {
    private String key;
    private Object value;

    public Values(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
