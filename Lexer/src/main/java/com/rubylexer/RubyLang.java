package com.rubylexer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RubyLang {

    private static Set<String> keywords = new HashSet<>(Arrays.asList(
            "BEGIN", "END", "__ENCODING__", "__END__", "__FILE__", "__LINE__",

            "alias", "and",
            "begin", "break",
            "case", "class",
            "def", "defined?", "do",
            "else", "elsif", "end", "ensure",
            "for",
            "if", "in", "include",
            "module", "next", "nil", "not",
            "or",
            "redo", "rescue", "retry", "return",
            "self", "super",
            "then",
            "undef", "unless", "until",
            "when", "while",
            "yield"
    ));

    private static Set<String> operations = new HashSet<>(Arrays.asList(
            "==", "!=", ">", "<", ">=", "<=", "<=>", "===", ".eql?", "equal?",
            "+=", "-=", "*=", "/=", "%=", "**=",
            "<<", ">>", "&&", "||", "!",
            "&", "|", "^", "~",
            "+", "-", "*", "/", "%", "**",
            "=",
            "..", "...",
            "defined?"
    ));


    private static Set<String> literals = new HashSet<>(Arrays.asList(
            "true", "false", "null", "TRUE", "FALSE", "NIL"
    ));

    public static boolean isKeyword(String word) {
        return keywords.contains(word);
    }

    public static boolean isLiteral(String word) {
        return literals.contains(word);
    }

    public static boolean isPartOfOperations(String s) {
        for (String op : operations) {
            if (op.startsWith(s))
                return true;
        }
        return false;
    }

    public static boolean isSpacing(Character c) {
        return Character.isWhitespace(c) && c != '\n';
    }

    public static boolean isSeparator(Character c) {
        return (c == ';') || (c == ' ') || (c == '\t') || (c == '\n') || (c == '\r')
                || (c == '(') || (c == ')') || (c == '[') || (c == ']') || (c == '{') || (c == '}');
    }

    public static boolean isOperatorStart(Character c) {
        return (c == '+') || (c == '-') || (c == '=') || (c == '>') || (c == '<') || (c == '(') || (c == '?') ||
                (c == '!') || (c == '%') || (c == '#') || (c == ':') || (c == '.') || (c == ',');
    }

}