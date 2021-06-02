package com.rubylexer;

import java.util.HashMap;
import java.util.Map;

public class Token {
    private Map<TokenType, String> map = new HashMap<>();
    {
        map.put(TokenType.NUMERIC_CONSTANT, "color: #83c385;");
        map.put(TokenType.OPERATOR, "color: blue; font-weight: bold;");
        map.put(TokenType.LITERAL, "color: #e47c4b;");
        map.put(TokenType.PUNCTUATION_MARK, "color: red;");
        map.put(TokenType.IDENTIFIER, "color: #e4e4e4;");
        map.put(TokenType.KEYWORD, "color: #0095ff; font-weight: bold;");
        map.put(TokenType.COMMENT, "color: #4aa724;");
        map.put(TokenType.ERROR, "color: white; text-decoration: underline; text-decoration-color:red");
        map.put(TokenType.SYMBOL, "color: #e47c4b; font-weight: bold; font-style: italic;");
    }

    private String CONTENT;
    private TokenType TOKEN_TYPE;

    public void setCONTENT(String CONTENT) {
        this.CONTENT = CONTENT;
    }

    public void setTOKEN_TYPE(TokenType TOKEN_TYPE) {
        this.TOKEN_TYPE = TOKEN_TYPE;
    }


    public Token() {
    }

    public Token(TokenType TOKEN_TYPE, String content) {
        this.CONTENT = content;
        this.TOKEN_TYPE = TOKEN_TYPE;
    }

    public TokenType getTOKEN_TYPE() {
        return TOKEN_TYPE;
    }

    public String getCONTENT() {
        return CONTENT;
    }

    private static String fillTo(String s, int n) {
        StringBuilder res = new StringBuilder(s);
        while (res.length() < n) {
            res.append(" ");
        }
        return res.toString();
    }

    public String toHtml() {
        if (TOKEN_TYPE.equals(TokenType.PUNCTUATION_MARK) && getCONTENT().equals("\\n"))
            return "<br>";

        String rs = getCONTENT();
        rs = rs.replace("<", "&#60;");
        rs = rs.replace(">", "&#62;");

        rs = rs.replace("\t", "&nbsp;");
        rs = rs.replace("  ", "&nbsp;&nbsp;&nbsp;");
        return "<span style='" + getStyle(getTOKEN_TYPE()) + "'>" + rs + "</span>";
    }

    private String getStyle(TokenType tokenType) {

        return map.get(tokenType);
    }


    @Override
    public String toString() {
        return "< " + fillTo(TOKEN_TYPE.toString(), 12) + ":  " + CONTENT + " >";
    }
}

