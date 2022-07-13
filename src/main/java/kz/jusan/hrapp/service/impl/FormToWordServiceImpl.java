package kz.jusan.hrapp.service.impl;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.*;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class FormToWordServiceImpl {

    private static List<String> KEYS = new ArrayList<>();

    private List<String> answers;



    @PostConstruct
    public void keysInit(){
        KEYS.add("FIO");
        KEYS.add("EXFIO");
        KEYS.add("BIRTHDAY");
        KEYS.add("ETHNICITY");
        KEYS.add("CITIZENSHIP");
        KEYS.add("SERIAL");
        KEYS.add("IDNUM");
        KEYS.add("ISSUED");
    }



    public void updateDocument(List<String> answers) throws InvalidFormatException, IOException {


        XWPFDocument doc = new XWPFDocument(OPCPackage.open("src/main/resources/templates/forms.docx")); //CHANGE PATH FOR THE ACTUAL ONE

        for (String key : KEYS) {
            for (XWPFTable tbl : doc.getTables()) {
                for (XWPFTableRow row : tbl.getRows()) {
                    for (XWPFTableCell cell : row.getTableCells()) {
                        for (XWPFParagraph p : cell.getParagraphs()) {
                            for (XWPFRun r : p.getRuns()) {
                                String text = r.getText(0);
                                if (text != null && text.contains(key)) {
                                    text = text.replace(key, "answers.get(i)");
                                    r.setText(text, 0);
                                }
                            }
                        }
                    }
                }
            }
            for (XWPFParagraph p : doc.getParagraphs()) {
                List<XWPFRun> runs = p.getRuns();
                if (runs != null) {
                    for (XWPFRun r : runs) {
                        String text = r.getText(0);
                        if (text != null && text.contains(key)) {
                            text = text.replace(key, "answers.get(i)");
                            r.setText(text, 0);
                        }
                    }
                }
            }
            for (XWPFParagraph p : doc.getParagraphs()) {
                List<XWPFRun> runs = p.getRuns();
                if (runs != null) {
                    for (XWPFRun r : runs) {
                        String text = r.getText(0);
                        if (text != null && text.contains("PIC")) {
                            String imgFile = "/home/administrator/Downloads/pic.jpg";
                            r.addPicture(new FileInputStream(imgFile), XWPFDocument.PICTURE_TYPE_JPEG, imgFile, Units.toEMU(100), Units.toEMU(100));
                            text = text.replace("PIC", "");
                            r.setText(text, 0);
                        }
                    }
                }
            }
        }

            doc.write(new FileOutputStream("/home/administrator/Downloads/output.docx"));
    }
}
