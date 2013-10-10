package bubble;

import java.awt.Color;
import java.awt.Cursor;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import bubble.parser.Parser;
import bubble.parser.PreProcessor;
import bubble.parser.SentenceParser;
import bubble.summarizer.BubbleSummarizer;
import bubble.summarizer.Wrapper;

import com.google.api.translate.Language;
import com.google.api.translate.Translate;

public class Gui extends javax.swing.JFrame {

    public Gui() {
        initComponents();
        this.setLocationRelativeTo(null);
        initFileChooser();
    }

    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jDialog1 = new javax.swing.JDialog();
        jLabel11 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jSplitPane1 = new javax.swing.JSplitPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        highlighttext = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        thesauruscheck = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        languagelist = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        genreport = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        filepathTextField = new javax.swing.JTextField();
        browse = new javax.swing.JButton();
        keywordsTextField = new javax.swing.JTextField();
        summarize = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        percentselect = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();

        jPopupMenu1.setName("jPopupMenu1");

        jPopupMenu2.setName("jPopupMenu2");

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance().getContext().getResourceMap(Gui.class);
        jDialog1.setTitle(resourceMap.getString("jDialog1.title"));
        jDialog1.setAlwaysOnTop(true);
        jDialog1.setLocationByPlatform(true);
        jDialog1.setMinimumSize(new java.awt.Dimension(400, 150));
        jDialog1.setModal(true);
        jDialog1.setName("jDialog1");

        jLabel11.setText(resourceMap.getString("jLabel11.text"));
        jLabel11.setName("jLabel11");

        jTextField3.setText(resourceMap.getString("jTextField3.text"));
        jTextField3.setName("jTextField3");

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(
                jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(jDialog1Layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                jDialog1Layout.createSequentialGroup().addContainerGap().addComponent(jLabel11).addPreferredGap(
                javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(
                jTextField3,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                412, Short.MAX_VALUE).addContainerGap()));
        jDialog1Layout.setVerticalGroup(jDialog1Layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                jDialog1Layout.createSequentialGroup().addGap(21, 21, 21).addGroup(
                jDialog1Layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel11).addComponent(
                jTextField3,
                javax.swing.GroupLayout.PREFERRED_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.PREFERRED_SIZE)).addContainerGap(24, Short.MAX_VALUE)));

        jFrame1.setName("jFrame1");

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(
                jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(jFrame1Layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 400,
                Short.MAX_VALUE));
        jFrame1Layout.setVerticalGroup(jFrame1Layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addGap(0, 300,
                Short.MAX_VALUE));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(resourceMap.getString("Form.title"));
        setName("Form");
        setResizable(false);

        jPanel1.setName("jPanel1");

        jTabbedPane1.setToolTipText(resourceMap.getString("jTabbedPane1.toolTipText"));
        jTabbedPane1.setName("jTabbedPane1");

        jSplitPane1.setDividerLocation(425);
        jSplitPane1.setName("jSplitPane1");

        jScrollPane2.setName("jScrollPane2");

        jTextArea2.setColumns(20);
        jTextArea2.setEditable(false);
        jTextArea2.setFont(new java.awt.Font("Arial Unicode MS", 0, 13));
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(5);
        jTextArea2.setName("jTextArea2");
        jScrollPane2.setViewportView(jTextArea2);

        jSplitPane1.setRightComponent(jScrollPane2);

        jScrollPane1.setName("jScrollPane1");

        jTextArea1.setColumns(20);
        jTextArea1.setEditable(false);
        jTextArea1.setFont(new java.awt.Font("Arial Unicode MS", 0, 13));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setName("jTextArea1");
        jScrollPane1.setViewportView(jTextArea1);

        jSplitPane1.setLeftComponent(jScrollPane1);

        jTabbedPane1.addTab(resourceMap.getString("jSplitPane1.TabConstraints.tabTitle"), jSplitPane1);

        jPanel4.setAutoscrolls(true);
        jPanel4.setName("jPanel4");

        jPanel5.setName("jPanel5");

        highlighttext.setFont(resourceMap.getFont("highlighttext.font"));
        highlighttext.setText(resourceMap.getString("highlighttext.text"));
        highlighttext.setToolTipText(resourceMap.getString("highlighttext.toolTipText"));
        highlighttext.setName("highlighttext");

        jLabel2.setFont(resourceMap.getFont("jCheckBox1.font"));
        jLabel2.setText(resourceMap.getString("jLabel2.text"));
        jLabel2.setName("jLabel2");

        thesauruscheck.setFont(resourceMap.getFont("highlighttext.font"));
        thesauruscheck.setText(resourceMap.getString("thesauruscheck.text"));
        thesauruscheck.setToolTipText(resourceMap.getString("thesauruscheck.toolTipText"));
        thesauruscheck.setName("thesauruscheck");

        jLabel3.setFont(resourceMap.getFont("jCheckBox1.font"));
        jLabel3.setText(resourceMap.getString("jLabel3.text"));
        jLabel3.setName("jLabel3");

        jLabel4.setFont(resourceMap.getFont("jCheckBox1.font"));
        jLabel4.setForeground(resourceMap.getColor("jLabel4.foreground"));
        jLabel4.setText(resourceMap.getString("jLabel4.text"));
        jLabel4.setName("jLabel4");

        languagelist.setFont(resourceMap.getFont("jCheckBox1.font"));
        languagelist.setModel(new javax.swing.DefaultComboBoxModel(
                new String[]{"English", "Afrikaans", "Albanian", "Arabic",
                    "Belarusian", "Bulgarian", "Chinese",
                    "Chinese Simplified", "Chinese Traditional", "Catalan",
                    "Croatian", "Czech", "Danish", "Dutch", "Estonian",
                    "Filipino", "Finnish", "French", "Galician", "German",
                    "Greek", "Hebrew", "Hindi", "Hungarian", "Icelandic",
                    "Indonesian", "Irish", "Italian", "Japanese", "Korean",
                    "Latvian", "Lithuanian", "Macedonian", "Malay",
                    "Maltese", "Norwegian", "Persian", "Polish",
                    "Portuguese", "Romanian", "Russian", "Spanish",
                    "Serbian", "Slovak", "Slovenian", "Swahili", "Swedish",
                    "Thai", "Turkish", "Ukrainian", "Vietnamese", "Welsh",
                    "Yiddish"}));
        languagelist.setToolTipText(resourceMap.getString("languagelist.toolTipText"));
        languagelist.setName("languagelist");

        jLabel5.setFont(resourceMap.getFont("jCheckBox1.font"));
        jLabel5.setText(resourceMap.getString("jLabel5.text"));
        jLabel5.setName("jLabel5");

        jLabel6.setFont(resourceMap.getFont("jCheckBox1.font"));
        jLabel6.setText(resourceMap.getString("jLabel6.text"));
        jLabel6.setName("jLabel6");

        genreport.setFont(resourceMap.getFont("genreport.font"));
        genreport.setText(resourceMap.getString("genreport.text"));
        genreport.setToolTipText(resourceMap.getString("genreport.toolTipText"));
        genreport.setName("genreport");

        jLabel13.setFont(resourceMap.getFont("jLabel13.font"));
        jLabel13.setText(resourceMap.getString("jLabel13.text"));
        jLabel13.setName("jLabel13");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(
                jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(jPanel5Layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                jPanel5Layout.createSequentialGroup().addGroup(
                jPanel5Layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                jPanel5Layout.createSequentialGroup().addGap(
                18,
                18,
                18).addComponent(
                jLabel4)).addGroup(
                jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(
                jPanel5Layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                highlighttext).addGroup(
                jPanel5Layout.createSequentialGroup().addGap(
                21,
                21,
                21).addComponent(
                jLabel2)))).addGroup(
                jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(
                jPanel5Layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                thesauruscheck).addGroup(
                jPanel5Layout.createSequentialGroup().addGap(
                21,
                21,
                21).addComponent(
                jLabel3)))).addGroup(
                jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(
                jPanel5Layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                jPanel5Layout.createSequentialGroup().addGap(
                25,
                25,
                25).addGroup(
                jPanel5Layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                jLabel5).addComponent(
                languagelist,
                javax.swing.GroupLayout.PREFERRED_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.PREFERRED_SIZE))).addComponent(
                jLabel6))).addGroup(
                jPanel5Layout.createSequentialGroup().addContainerGap().addGroup(
                jPanel5Layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                jPanel5Layout.createSequentialGroup().addGap(
                21,
                21,
                21).addComponent(
                jLabel13)).addComponent(
                genreport)))).addContainerGap(25, Short.MAX_VALUE)));
        jPanel5Layout.setVerticalGroup(jPanel5Layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                jPanel5Layout.createSequentialGroup().addContainerGap().addComponent(genreport).addPreferredGap(
                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel13).addGap(24, 24, 24).addComponent(highlighttext).addPreferredGap(
                javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel2).addGap(31, 31, 31).addComponent(thesauruscheck).addPreferredGap(
                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel3).addGap(31, 31, 31).addComponent(jLabel6).addPreferredGap(
                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(
                languagelist,
                javax.swing.GroupLayout.PREFERRED_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(
                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jLabel5).addPreferredGap(
                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                83, Short.MAX_VALUE).addComponent(jLabel4).addContainerGap()));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(
                jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(jPanel4Layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                jPanel4Layout.createSequentialGroup().addGap(272, 272, 272).addComponent(jPanel5,
                javax.swing.GroupLayout.PREFERRED_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(223, Short.MAX_VALUE)));
        jPanel4Layout.setVerticalGroup(jPanel4Layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                jPanel4Layout.createSequentialGroup().addGap(22, 22, 22).addComponent(jPanel5,
                javax.swing.GroupLayout.PREFERRED_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(17, Short.MAX_VALUE)));

        jTabbedPane1.addTab(resourceMap.getString("jPanel4.TabConstraints.tabTitle"), jPanel4);

        jPanel3.setName("jPanel3");

        jLabel12.setFont(resourceMap.getFont("jLabel12.font"));
        jLabel12.setText(resourceMap.getString("jLabel12.text"));
        jLabel12.setName("jLabel12");

        jLabel14.setFont(resourceMap.getFont("jLabel12.font"));
        jLabel14.setText(resourceMap.getString("jLabel14.text"));
        jLabel14.setName("jLabel14");

        jLabel15.setFont(resourceMap.getFont("jLabel12.font"));
        jLabel15.setText(resourceMap.getString("jLabel15.text"));
        jLabel15.setName("jLabel15");

        jLabel16.setFont(resourceMap.getFont("jLabel12.font"));
        jLabel16.setText(resourceMap.getString("jLabel16.text"));
        jLabel16.setName("jLabel16");

        jLabel18.setFont(resourceMap.getFont("jLabel12.font"));
        jLabel18.setText(resourceMap.getString("jLabel18.text"));
        jLabel18.setName("jLabel18");

        jLabel20.setFont(resourceMap.getFont("jLabel12.font"));
        jLabel20.setText(resourceMap.getString("jLabel20.text"));
        jLabel20.setName("jLabel20");

        jLabel21.setText(resourceMap.getString("jNoOfWords.text"));
        jLabel21.setName("jNoOfWords");

        jLabel22.setText(resourceMap.getString("jNoOfUniqueWords.text"));
        jLabel22.setName("jNoOfUniqueWords");

        jLabel23.setText(resourceMap.getString("jNoOfSentences.text"));
        jLabel23.setName("jNoOfSentences");

        jLabel24.setText(resourceMap.getString("jNoOfUsefulSentences.text"));
        jLabel24.setName("jNoOfUsefulSentences");

        jLabel27.setText(resourceMap.getString("jPercent.text"));
        jLabel27.setName("jPercent");

        jLabel28.setText(resourceMap.getString("jSummarizedText.text"));
        jLabel28.setName("jSummarizedText");

        jLabel17.setFont(resourceMap.getFont("jLabel17.font"));
        jLabel17.setForeground(resourceMap.getColor("jLabel17.foreground"));
        jLabel17.setText(resourceMap.getString("jLabel17.text"));
        jLabel17.setName("jLabel17");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(
                jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(jPanel3Layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                jPanel3Layout.createSequentialGroup().addGroup(
                jPanel3Layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                jPanel3Layout.createSequentialGroup().addGap(
                237,
                237,
                237).addGroup(
                jPanel3Layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.TRAILING).addComponent(
                jLabel20).addComponent(
                jLabel16).addComponent(
                jLabel15).addComponent(
                jLabel12).addComponent(
                jLabel18).addComponent(
                jLabel14)).addGap(
                120,
                120,
                120).addGroup(
                jPanel3Layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                jLabel24).addComponent(
                jLabel23).addComponent(
                jLabel22).addComponent(
                jLabel21).addComponent(
                jLabel27).addComponent(
                jLabel28))).addGroup(
                jPanel3Layout.createSequentialGroup().addGap(
                315,
                315,
                315).addComponent(
                jLabel17))).addContainerGap(266, Short.MAX_VALUE)));

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
                new java.awt.Component[]{jLabel12, jLabel14, jLabel15,
                    jLabel16, jLabel18, jLabel20});

        jPanel3Layout.setVerticalGroup(jPanel3Layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                jPanel3Layout.createSequentialGroup().addGap(73, 73, 73).addComponent(jLabel17).addPreferredGap(
                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                61, Short.MAX_VALUE).addGroup(
                jPanel3Layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel12).addComponent(jLabel21)).addGap(18, 18, 18).addGroup(
                jPanel3Layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel15).addComponent(jLabel22)).addGap(18, 18, 18).addGroup(
                jPanel3Layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel18).addComponent(jLabel23)).addGap(18, 18, 18).addGroup(
                jPanel3Layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel14).addComponent(jLabel24)).addGap(18, 18, 18).addGroup(
                jPanel3Layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel16).addComponent(jLabel27)).addGap(18, 18, 18).addGroup(
                jPanel3Layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel20).addComponent(jLabel28)).addGap(116, 116, 116)));

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL,
                new java.awt.Component[]{jLabel12, jLabel14, jLabel15,
                    jLabel16, jLabel18, jLabel20});

        jTabbedPane1.addTab(resourceMap.getString("jPanel3.TabConstraints.tabTitle"), jPanel3);

        jPanel6.setName("jPanel6");

        jLabel7.setText(resourceMap.getString("jLabel7.text"));
        jLabel7.setName("jLabel7");

        jLabel8.setText(resourceMap.getString("jLabel8.text"));
        jLabel8.setName("jLabel8");

        filepathTextField.setEditable(false);
        filepathTextField.setText(resourceMap.getString("filepathTextField.text"));
        filepathTextField.setName("filepathTextField");

        browse.setText(resourceMap.getString("browse.text"));
        browse.setToolTipText(resourceMap.getString("browse.toolTipText"));
        browse.setName("browse");
        browse.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseActionPerformed(evt);
            }
        });

        keywordsTextField.setFont(new java.awt.Font("Arial Unicode MS", 0, 11));
        keywordsTextField.setText(resourceMap.getString("keywordsTextField.text"));
        keywordsTextField.setName("keywordsTextField");

        summarize.setText(resourceMap.getString("summarize.text"));
        summarize.setToolTipText(resourceMap.getString("summarize.toolTipText"));
        summarize.setName("summarize");
        summarize.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                summarizeActionPerformed(evt);
            }
        });

        jLabel9.setText(resourceMap.getString("jLabel9.text"));
        jLabel9.setName("jLabel9");

        percentselect.setModel(new javax.swing.SpinnerNumberModel(50, 1, 100, 1));
        percentselect.setToolTipText(resourceMap.getString("percentselect.toolTipText"));
        percentselect.setName("percentselect");

        jLabel10.setText(resourceMap.getString("jLabel10.text"));
        jLabel10.setName("jLabel10");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(
                jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(jPanel6Layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                jPanel6Layout.createSequentialGroup().addContainerGap().addGroup(
                jPanel6Layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                jPanel6Layout.createSequentialGroup().addComponent(
                jLabel7).addPreferredGap(
                javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(
                filepathTextField,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                723,
                Short.MAX_VALUE).addPreferredGap(
                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(
                browse)).addGroup(
                jPanel6Layout.createSequentialGroup().addComponent(
                jLabel8).addPreferredGap(
                javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(
                keywordsTextField,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                569,
                Short.MAX_VALUE).addPreferredGap(
                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(
                jLabel9).addPreferredGap(
                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(
                percentselect,
                javax.swing.GroupLayout.PREFERRED_SIZE,
                47,
                javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(
                javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(
                jLabel10).addPreferredGap(
                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(
                summarize))).addContainerGap()));

        jPanel6Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL,
                new java.awt.Component[]{browse, summarize});

        jPanel6Layout.setVerticalGroup(jPanel6Layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                jPanel6Layout.createSequentialGroup().addGap(20, 20, 20).addGroup(
                jPanel6Layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.BASELINE).addComponent(jLabel7).addComponent(
                filepathTextField,
                javax.swing.GroupLayout.PREFERRED_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(browse)).addPreferredGap(
                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addGroup(
                jPanel6Layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                jPanel6Layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.BASELINE).addComponent(
                jLabel8).addComponent(
                keywordsTextField,
                javax.swing.GroupLayout.PREFERRED_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.PREFERRED_SIZE)).addGroup(
                jPanel6Layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.BASELINE).addComponent(
                summarize).addComponent(
                percentselect,
                javax.swing.GroupLayout.PREFERRED_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.PREFERRED_SIZE).addComponent(
                jLabel10).addComponent(
                jLabel9))).addContainerGap(20, Short.MAX_VALUE)));

        jPanel6Layout.linkSize(javax.swing.SwingConstants.VERTICAL,
                new java.awt.Component[]{filepathTextField, jLabel8, jLabel9,
                    keywordsTextField, summarize});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(
                jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jTabbedPane1,
                javax.swing.GroupLayout.DEFAULT_SIZE, 895,
                Short.MAX_VALUE));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                jPanel1Layout.createSequentialGroup().addComponent(
                jPanel6,
                javax.swing.GroupLayout.PREFERRED_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.PREFERRED_SIZE).addPreferredGap(
                javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(
                jTabbedPane1,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                492, Short.MAX_VALUE)));

        jPanel2.setName("jPanel2");

        jLabel1.setFont(resourceMap.getFont("jLabel1.font"));
        jLabel1.setText(resourceMap.getString("jLabel1.text"));
        jLabel1.setName("jLabel1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(
                jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(jPanel2Layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                jPanel2Layout.createSequentialGroup().addContainerGap().addComponent(jLabel1).addContainerGap(852,
                Short.MAX_VALUE)));
        jPanel2Layout.setVerticalGroup(jPanel2Layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addComponent(jLabel1));

        jMenuBar1.setName("jMenuBar1");

        jMenu1.setText(resourceMap.getString("jMenu1.text"));
        jMenu1.setName("jMenu1");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
                java.awt.event.KeyEvent.VK_O,
                java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText(resourceMap.getString("jMenuItem1.text"));
        jMenuItem1.setName("jMenuItem1");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
                java.awt.event.KeyEvent.VK_O,
                java.awt.event.InputEvent.ALT_MASK));
        jMenuItem2.setText(resourceMap.getString("jMenuItem2.text"));
        jMenuItem2.setToolTipText(resourceMap.getString("jMenuItem2.toolTipText"));
        jMenuItem2.setName("jMenuItem2");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
                java.awt.event.KeyEvent.VK_S,
                java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem3.setText(resourceMap.getString("jMenuItem3.text"));
        jMenuItem3.setToolTipText(resourceMap.getString("jMenuItem3.toolTipText"));
        jMenuItem3.setName("jMenuItem3");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
                java.awt.event.KeyEvent.VK_I,
                java.awt.event.InputEvent.ALT_MASK));
        jMenuItem4.setText(resourceMap.getString("jMenuItem4.text"));
        jMenuItem4.setToolTipText(resourceMap.getString("jMenuItem4.toolTipText"));
        jMenuItem4.setName("jMenuItem4");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
                java.awt.event.KeyEvent.VK_E,
                java.awt.event.InputEvent.ALT_MASK));
        jMenuItem5.setText(resourceMap.getString("jMenuItem5.text"));
        jMenuItem5.setToolTipText(resourceMap.getString("jMenuItem5.toolTipText"));
        jMenuItem5.setName("jMenuItem5");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
                java.awt.event.KeyEvent.VK_A,
                java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem7.setText(resourceMap.getString("jMenuItem7.text"));
        jMenuItem7.setName("jMenuItem7");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {

            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(
                java.awt.event.KeyEvent.VK_X,
                java.awt.event.InputEvent.ALT_MASK));
        jMenuItem6.setText(resourceMap.getString("jMenuItem6.text"));
        jMenuItem6.setToolTipText(resourceMap.getString("jMenuItem6.toolTipText"));
        jMenuItem6.setName("jMenuItem6");
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
                getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addComponent(
                jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE).addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout.createSequentialGroup().addComponent(
                jPanel1,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                Short.MAX_VALUE).addPreferredGap(
                javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(
                jPanel2,
                javax.swing.GroupLayout.PREFERRED_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.PREFERRED_SIZE)));

        pack();
    }

    private void browseActionPerformed(java.awt.event.ActionEvent evt) {
        xml = false;
        if (jfc.showOpenDialog(jPanel1) == JFileChooser.APPROVE_OPTION) {
            filepathTextField.setText(jfc.getSelectedFile().getAbsolutePath());
            jTextArea2.setText("");
            keywordsTextField.setText("");
            mode = filters.indexOf(jfc.getFileFilter());
            PreProcessor preprocess = new PreProcessor();
            con = preprocess.preProcess(filepathTextField.getText(), mode);
            jTextArea1.setText(con);
        }
    }

    private void summarizeActionPerformed(java.awt.event.ActionEvent evt) {
        summarize.setEnabled(false);
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        String[] args;
        List<String> sentences = null;
        String[] sentences2;

        if (!filepathTextField.getText().equals("")) {

            if (thesauruscheck.isSelected()) {
                args = new String[5];
            } else {
                args = new String[4];
            }

            args[0] = filepathTextField.getText();
            args[1] = percentselect.getValue().toString();
            args[2] = keywordsTextField.getText();

            args[3] = con;
            String lang = languagelist.getSelectedItem().toString().replace(
                    " ", "_").toUpperCase();
            boolean translate = !lang.equals("ENGLISH");
            if (translate) {

                SentenceParser sd = new SentenceParser(con);
                sentences = sd.getSentences();

                Translate.setHttpReferrer("www.narendran.net");

                try {

                    args[3] = Translate.execute(con, Language.valueOf(lang),
                            Language.ENGLISH);
                    args[2] = Translate.execute(keywordsTextField.getText(),
                            Language.valueOf(lang), Language.ENGLISH);
                } catch (Exception ex) {
                    System.err.println(ex);
                }
            }
            Wrapper.main(args);

            String result = Wrapper.getContent();
            if (translate) {

                int[] sentenceIndex = Wrapper.getSentenceIndex();
                sentences2 = new String[sentenceIndex.length];
                StringBuilder summary = new StringBuilder();
                for (int i = 0; i < sentenceIndex.length; i++) {
                    summary.append(sentences.get(sentenceIndex[i]).toString() + " ");
                    sentences2[i] = sentences.get(sentenceIndex[i]).toString();
                }
                result = summary.toString();

            }

            jTextArea2.setText(result);
            sentences2 = Wrapper.getSentences();
            if (highlighttext.isSelected() == true) {
                highlightdocument(jTextArea1, sentences2);
                String xx = keywordsTextField.getText().trim();
                if (!xx.equals("")) {
                    highlightdocument(jTextArea2, xx.split("[ ,]"));
                }

            }
            if (genreport.isSelected() == true) {

                Parser myparser = Wrapper.getParser();
                report(myparser);
            }
        }

        this.setCursor(null);
        summarize.setEnabled(true);

    }

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {
        xml = true;
        JFileChooser ch = new JFileChooser();
        ch.setFileFilter(new FileNameExtensionFilter("XML Files", "xml",
                "XML"));
        if (ch.showOpenDialog(jPanel1) == JFileChooser.APPROVE_OPTION) {
            xmlpath = ch.getSelectedFile().getAbsolutePath();
        }

        try {

            String[] xm = PreProcessor.XMLtotxt(xmlpath);
            filepathTextField.setText(xmlpath);
            keywordsTextField.setText(xm[2]);
            jTextArea1.setText(xm[0]);
            percentselect.setValue(Integer.valueOf(xm[1]));
            thesauruscheck.setSelected(Boolean.valueOf(xm[3]));
            languagelist.setSelectedItem(xm[4]);

        } catch (Exception ex) {
            System.err.println(ex);
        }

    }

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {
        new frame().setVisible(true);

    }

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {

        JFileChooser ah = new JFileChooser();
        ah.setApproveButtonText("Save");
        ah.setDialogType(JFileChooser.SAVE_DIALOG);
        ah.setDialogTitle("Export XML");
        ah.setFileFilter(new FileNameExtensionFilter("xml", "XML"));
        if (ah.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            xmlsavepath = ah.getSelectedFile().getAbsolutePath();

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = null;
            try {
                documentBuilder = documentBuilderFactory.newDocumentBuilder();
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null,
                        ex);
            }
            Document document = documentBuilder.newDocument();
            Element rootElement = document.createElement("summarizer");
            document.appendChild(rootElement);

            element[0] = "input_text";
            element[1] = "percentage";
            element[2] = "keywords";
            element[3] = "thesaurus";
            element[4] = "language";

            data[0] = jTextArea1.getText();
            data[1] = percentselect.getValue().toString();
            data[2] = keywordsTextField.getText();
            data[3] = null;

            if (thesauruscheck.isSelected() == true) {
                data[3] = "true";
            } else {
                data[3] = "false";
            }
            data[4] = languagelist.getSelectedItem().toString();

            for (int i = 0; i < 5; i++) {
                Element em = document.createElement(element[i]);
                em.appendChild(document.createTextNode(data[i]));
                rootElement.appendChild(em);
            }

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = null;
            try {
                transformer = transformerFactory.newTransformer();
            } catch (TransformerConfigurationException ex) {
                Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null,
                        ex);
            }
            DOMSource source = new DOMSource(document);
            OutputStream str = null;
            try {
                str = new FileOutputStream(xmlsavepath);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null,
                        ex);
            }
            StreamResult result = new StreamResult(str);
            try {
                transformer.transform(source, result);
            } catch (TransformerException ex) {
                Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null,
                        ex);
            }
            jLabel1.setText("Saved the XML to:" + xmlsavepath);
        } else {
            jLabel1.setText("Export Cancelled by user");
        }
    }

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {
        html = true;
        url = true;
        String urs = JOptionPane.showInputDialog(this, "Enter an URL or path to a HTML file in local disk:", "Enter the URL",
                JOptionPane.PLAIN_MESSAGE);
        if(urs.equals(""))
            JOptionPane.showMessageDialog(this, "Please check the input");

        urltext = PreProcessor.HTMLtotxt(urs);
        jTextArea1.setText(urltext);

    }

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
        xml = false;
        if (jfc.showOpenDialog(jPanel1) == JFileChooser.APPROVE_OPTION) {
            filepathTextField.setText(jfc.getSelectedFile().getAbsolutePath());
            jTextArea2.setText("");
            keywordsTextField.setText("");
            mode = filters.indexOf(jfc.getFileFilter());
            PreProcessor preprocess = new PreProcessor();
            con = preprocess.preProcess(filepathTextField.getText(), mode);
            jTextArea1.setText(con);
        }
    }

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {
        String path = null;
        JFileChooser ah = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Plain Text files", "txt", "TXT");

        ah.setApproveButtonToolTipText("Click to save the Summarized text");
         ah.setFileFilter(filter);
        ah.setDialogTitle("Save Summarized text");
     
        
        if (ah.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            path = ah.getSelectedFile().getAbsolutePath();
        }

        if(!path.endsWith(".txt"))
            path = path.concat(".txt");
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(path));
            out.write(jTextArea2.getText());
            out.close();
        } catch (IOException e) {
            System.err.println(e);
        }

    }

    private void initFileChooser() {
        filters = new ArrayList<FileNameExtensionFilter>(5);
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "Plain Text files", "txt", "TXT");
        filters.add(filter);
        filter = new FileNameExtensionFilter("Adobe PDF Files", "pdf", "PDF");
        filters.add(filter);
        jfc.setAcceptAllFileFilterUsed(false);
        jfc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        for (FileNameExtensionFilter fileNameExtensionFilter : filters) {
            jfc.addChoosableFileFilter(fileNameExtensionFilter);
        }
        jfc.setFileFilter(filters.get(0));
    }

    public void highlightdocument(JTextArea txtarea, String[] summaries) {

        Highlighter h = txtarea.getHighlighter();

        h.removeAllHighlights();
        try {
            int startPosition = -1;
            int endPosition = -1;
            int counter = 0;
            String sourceDocument = txtarea.getText().toLowerCase();

            for (String str : summaries) {
                ++counter;
                startPosition = sourceDocument.indexOf(str.toLowerCase());
                if (startPosition != -1) {
                    endPosition = startPosition + str.length() + 1;
                    h.addHighlight(startPosition, endPosition,
                            new DefaultHighlighter.DefaultHighlightPainter(
                            Color.YELLOW));
                }
            }

        } catch (Exception ex) {
            System.err.println(ex);
        }
        txtarea.setCaretPosition(0);

    }

    public void report(Parser parser) {

        int usefulsentences = parser.getNumUsefulSentences();
        int totalsentences = parser.getNumSentences();
        int noofwords = parser.getNumTotalWords();
        int noofuniquewords = parser.getNumUniqueWords();

        BubbleSummarizer mySummariser = new BubbleSummarizer();

        int percent = Integer.parseInt(percentselect.getValue().toString());
        mySummariser.Summarize(parser, percent);

        int numberofsentences = Math.round(parser.getNumUsefulSentences() * percent / 100.0F);
        int[] sentenceIndex = mySummariser.Summarize(parser, numberofsentences);

        int sentencesInSummarizedText = sentenceIndex.length;

        jLabel21.setText(convert(noofwords));
        jLabel22.setText(convert(noofuniquewords));
        jLabel23.setText(convert(totalsentences));
        jLabel24.setText(convert(usefulsentences));
        jLabel27.setText(convert(percent));
        jLabel28.setText(convert(sentencesInSummarizedText));

    }

    public static String convert(int i) {
        return "" + i;
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Gui().setVisible(true);
            }
        });
    }
    private String[] element = new String[5], data = new String[5];
    private boolean xml = false, html = false, url = false;
    private String xmlpath, urltext, xmlsavepath, con = "";
    private int mode;
    private ArrayList<FileNameExtensionFilter> filters;
    private JFileChooser jfc = new JFileChooser(".");
    private javax.swing.JButton browse;
    private javax.swing.JTextField filepathTextField;
    private javax.swing.JCheckBox genreport;
    private javax.swing.JCheckBox highlighttext;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField keywordsTextField;
    private javax.swing.JComboBox languagelist;
    private javax.swing.JSpinner percentselect;
    private javax.swing.JButton summarize;
    private javax.swing.JCheckBox thesauruscheck;
}
