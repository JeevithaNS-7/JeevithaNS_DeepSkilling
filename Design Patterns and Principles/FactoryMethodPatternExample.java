interface Document {
    void open();
}

class WordDocument implements Document {
    public void open() {
        System.out.println("Word Document Created");
    }
}

class PdfDocument implements Document {
    public void open() {
        System.out.println("PDF Document Created");
    }
}

class ExcelDocument implements Document {
    public void open() {
        System.out.println("Excel Document Created");
    }
}

abstract class DocumentFactory {
    abstract Document createDocument();
}

class WordFactory extends DocumentFactory {
    public Document createDocument() {
        return new WordDocument();
    }
}

class PdfFactory extends DocumentFactory {
    public Document createDocument() {
        return new PdfDocument();
    }
}

class ExcelFactory extends DocumentFactory {
    public Document createDocument() {
        return new ExcelDocument();
    }
}

public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        DocumentFactory f1 = new WordFactory();
        Document d1 = f1.createDocument();
        d1.open();

        DocumentFactory f2 = new PdfFactory();
        Document d2 = f2.createDocument();
        d2.open();

        DocumentFactory f3 = new ExcelFactory();
        Document d3 = f3.createDocument();
        d3.open();
    }
}