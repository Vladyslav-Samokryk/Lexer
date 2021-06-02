package com.rubylexer;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Implemented 2 options for output

        lexToPrintTokens("./input/ruby_test_file.rb");
        lexToHtml("./input/ruby_test_file.rb", "./output/index.html");
    }

    private static void lexToPrintTokens(String inPath) throws IOException {
        Lexer lexer = new Lexer(inPath);

        Token t = lexer.getNextToken();
        while (t != null) {
            System.out.println(t);
            t = lexer.getNextToken();
        }
    }

    private static void lexToHtml(String inPath, String outPath) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(outPath));

        writer.write("<html><head> <meta charset=\"utf-8\"><title>Lex " + inPath + "</title>" +
                "<style type=\"text/css\">" +
                "html, body {margin: 5px; padding: 5px; background: #252525;}" +
                "span {font-size: 110%;margin: 1px; padding: 1px}" +
                "</style>" +
                "</head><body></html>");

        Lexer lexer = new Lexer(inPath);
        lexer.setTokenizedSpaces(true);

        Token t = lexer.getNextToken();
        while (t != null) {
            writer.write(t.toHtml());
            t = lexer.getNextToken();
        }
        writer.write("</html>");

        writer.close();
    }
}
