package com.sumeet.kraiglist.pdfview;

import java.awt.Color;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfWriter;

public class PdfReportView extends AbstractPdfView
{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document pdfdoc, PdfWriter pdfwriter, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		HttpSession session=request.getSession();
		String name = (String)session.getAttribute("firstname");
		if(name == null){
			name = "";
		}
		
		Font font_helvetica_12_normal_black = new Font(Font.HELVETICA, 12, Font.NORMAL, Color.BLACK); 
		Font font_courier_16_italic_blue = new Font(Font.COURIER, 10, Font.ITALIC, Color.BLUE);
		Font font_courier_16_italic_red = new Font(Font.COURIER, 16, Font.ITALIC, Color.BLUE);
		Font font_times_16_bold_green = new Font(Font.TIMES_ROMAN, 10, Font.NORMAL, Color.BLACK);
		
		Paragraph prg0 = new Paragraph("                                             Terms of Use of MyNEU KRAIGLIST", font_helvetica_12_normal_black);
		Paragraph prg1 = new Paragraph("____________________________________________________________________________________________________________", font_courier_16_italic_red);
		Paragraph prg2 = new Paragraph("");
		Chunk c1 = new Chunk("Hello "+ name + ",", font_courier_16_italic_blue);
		Paragraph prg3 = new Paragraph("PRODUCT SALES : "
+ "The GSI Products listed on this Site are offered for sale solely pursuant to GSI’s standard terms and conditions of sale applicable"
+ "to such products. The terms and conditions are accessible for viewing by clicking on the link on each product line home page."
+ "GSI objects to and rejects any other terms that may be proposed by any customer or potential customer. No offers to sell or purchase"
+ "GSI products are valid and binding on GSI unless and until specifically accepted, in writing, by GSI.", font_times_16_bold_green);
		//Phrase phr2 = new Phrase("Phrase 2", font_helvetica_16_normal_blue);
		Paragraph prg4 = new Paragraph("");
		Paragraph prg5 = new Paragraph("LICENSE TO USE THIS SITE : "
				+ "We at the GSI Group Inc. and its subsidiaries (“GSI”) are happy to have you as a visitor. We have established the following"
				+ "terms and conditions, including our Privacy Statement, as a requirement for visitors using our site. In order to use our site, you"
+ "must agree to these terms and conditions (“Terms”). BY CHOOSING TO ACCESS AND USE THIS SITE, YOU ARE EXPRESSLY"
+ "AGREEING TO BE LEGALLY BOUND BY THESE TERMS. IF YOU DO NOT AGREE, DO NOT USE OR VIEW THE SITE."
+ "These Terms apply only to the use of this Site and do not supercede any other contractual agreement between you and GSI."
+ "Use of Materials: Upon your agreement to the Terms, GSI grants you the right to view the site and to download materials from"
+ "this site for your personal, non-commercial use. You are not authorized to use the materials for any other purpose. If you do"
+ "download or otherwise reproduce the materials from this Site, you must reproduce all of GSI’s proprietary markings, such as"
+ "copyright and trademark notices, in the same form and manner as the original."
+ "Private Pages: Some parts of this Site are not available to the general public, but only to certain business associates of GSI."
+ "These sections may only be accessed by authorized entities and are controlled by password-protected access. If you are not"
+ "authorized to use these sections, then you agree that you will not attempt to gain access. If you are authorized, then by accessing"
+ "those areas, you expressly agree to the supplemental terms that are posted as part of the access process."
+ "No Harmful Use: In exchange for our permission to use this Site, you agree that you will not do anything to harm the functioning"
+ "or content of the Site. You will not attempt to upload, insert or change any information or image to or on this Site, except for providing"
+ "information where prompted by the Site. You agree that you will not take any action that imposes an unreasonably or disproportionately"
+ "large load on the Site or interferes with its functioning. You also agree that you will not use any false identity"
+ "when interacting with the Site, or do anything that is fraudulent, obscene, libelous or legally prohibited."
+ "You may not use any “deep-link”, “page-scrape”, “robot”, “spider” or any other automatic device, program, algorithm or methodology"
+ "or any similar or equivalent manual process to access, acquire, copy or monitor any portion of the Site or any of its content,"
+ "or in any way reproduce or circumvent the navigational structure or presentation of the Site."
+ "INDEMNITY: YOU AGREE THAT YOU WILL DEFEND, INDEMNIFY AND HOLD HARMLESS GSI, ITS CUSTOMERS, SUPPLIERS"
+ "AND JOINT VENTURE PARTNERS AND THEIR RESPECTIVE EMPLOYEES, OFFICERS, DIRECTORS, CONTRACTORS,"
+ "VENDORS, ASSIGNEES AND AGENTS FOR AND AGAINST ANY COSTS, CLAIMS, DAMAGES, LOSSES, OR"
+ "OTHER LIABILITIES ARISING FROM YOUR USE OF THE SITE IN BREACH OF THESE TERMS OR IN VIOLATION OF THE"
+ "LAW. IF GSI TAKES ANY LEGAL ACTION AGAINST YOU AS A RESULT OF YOUR VIOLATION OF THESE TERMS, YOU"
+ "AGREE THAT YOU WILL BE RESPONSIBLE FOR AND WILL PAY ALL OF GSI’S LEGAL FEES IN CONNECTION WITH"
+ "SUCH ACTION. ", font_times_16_bold_green);
		
		pdfdoc.add(c1);
		pdfdoc.add(prg0);
		pdfdoc.add(prg1);
		pdfdoc.add(prg2);
		pdfdoc.add(prg3);
		pdfdoc.add(prg4);
		pdfdoc.add(prg5);
	
	}

}
