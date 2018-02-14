package org.o7planning.springmvcshoppingcart.view;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.o7planning.springmvcshoppingcart.model.CartInfo;
import org.o7planning.springmvcshoppingcart.model.CartLineInfo;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import org.o7planning.springmvcshoppingcart.util.Utils;



public class ItextPdfView extends AbstractITextPdfView {


    @Override
    protected void buildPdfDocument(Map<String, Object> model,
                                    Document document, PdfWriter writer, HttpServletRequest request,
                                    HttpServletResponse response) throws Exception {

        @SuppressWarnings("unchecked")
        CartInfo CartInfo = Utils.getCartInSession(request);

        	PdfPTable table = new PdfPTable(4);
        	table.setWidths(new int[]{30, 30, 30, 30});

        	table.addCell("Nombre");
        	table.addCell("Email");
        	table.addCell("Telefono");
        	table.addCell("Direccion");
        
        
        	table.addCell(String.valueOf(CartInfo.getCustomerInfo().getName()));
            table.addCell(String.valueOf(CartInfo.getCustomerInfo().getEmail()));
            table.addCell(String.valueOf(CartInfo.getCustomerInfo().getPhone()));
            table.addCell(String.valueOf(CartInfo.getCustomerInfo().getAddress()));
        

            PdfPTable table2 = new PdfPTable(4);
            table2.setWidths(new int[]{30, 30, 30, 30});
            
            table2.addCell("Nombre");
        	table2.addCell("Cantidad");
        	table2.addCell("Precio");
        	table2.addCell("Foto");
        
        	for(CartLineInfo CartInfo1 : CartInfo.getCartLines()) {
	        	table2.addCell(String.valueOf(CartInfo1.get));
	            table2.addCell(String.valueOf(CartInfo1.));
	            table2.addCell(String.valueOf(CartInfo1.));
	            table2.addCell(String.valueOf(CartInfo1.));
        	}

        document.add(table);
        document.add(table2);
    }

}