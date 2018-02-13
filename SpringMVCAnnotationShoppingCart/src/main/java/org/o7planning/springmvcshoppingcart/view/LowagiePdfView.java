
package org.o7planning.springmvcshoppingcart.view;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import org.o7planning.springmvcshoppingcart.model.OrderDetailInfo;
import org.springframework.web.servlet.view.document.AbstractPdfView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

public class LowagiePdfView extends AbstractPdfView {


    //@Override
    protected void buildPdfDocument(Map<String, Object> model,
                                    Document document, PdfWriter writer,
                                    HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        @SuppressWarnings("unchecked")
        List<OrderDetailInfo> courses = (List<OrderDetailInfo>) model.get("courses");

        PdfPTable table = new PdfPTable(3);

        table.addCell("ID");
        table.addCell("ProductName");
        table.addCell("Quanity");
        table.addCell("Price");

        for (OrderDetailInfo course : courses){
        	 table.addCell(String.valueOf(course.getId()));
             table.addCell(String.valueOf(course.getProductName()));
             table.addCell(String.valueOf(course.getQuanity()));
             table.addCell(String.valueOf(course.getPrice()));
        }

        document.add(table);
    }
}