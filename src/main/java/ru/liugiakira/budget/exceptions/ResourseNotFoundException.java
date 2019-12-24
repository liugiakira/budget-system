package ru.liugiakira.budget.exceptions;

/**
 * @author k.yakovleva
 */
public class ResourseNotFoundException extends RuntimeException {
    public ResourseNotFoundException(String exception) {
        super(exception);
    }
}
