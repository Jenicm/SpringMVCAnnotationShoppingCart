package org.o7planning.springmvcshoppingcart.view;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.o7planning.springmvcshoppingcart.model.CartLineInfo;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class ItextPdfView extends AbstractITextPdfView {


    @Override
    protected void buildPdfDocument(Map<String, Object> model,
                                    Document document, PdfWriter writer, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        @SuppressWarnings("unchecked")
        List<CartLineInfo> courses = (List<CartLineInfo>) model.get("courses");

        PdfPTable table = new PdfPTable(3);
        table.setWidths(new int[]{10, 60, 30, 30});

        table.addCell("ID");
        table.addCell("ProductName");
        table.addCell("Quanity");
        table.addCell("Price");

        for (CartLineInfo course : courses){
            table.addCell(String.valueOf(course.getId()));
            table.addCell(String.valueOf(course.getProductInfo()));
            table.addCell(String.valueOf(course.getQuantity()));
            table.addCell(String.valueOf(course.getPrice()));
        }



        document.add(table);
    }

}