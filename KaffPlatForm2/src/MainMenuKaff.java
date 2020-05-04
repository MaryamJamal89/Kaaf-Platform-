
import static javafx.application.ConditionalFeature.SWT;
import jdk.nashorn.tools.Shell;

public class MainMenuKaff {

    protected Shell shell;

    /**
     * Launch the application.
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            MainMenuKaff window = new MainMenuKaff();
            window.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Open the window.
     */
    public void open() {
        JDisplay display = JDisplay.getDefault();
        createContents();
        shell.open();
        shell.layout();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }

    /**
     * Create contents of the window.
     */
    protected void createContents() {
        shell = new Shell();
        shell.setSize(616, 440);
        shell.setText("منصة كاف");

        Composite background = new Composite(shell, SWT.NONE);
        background.setLocation(0, 0);
        background.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
        background.setSize(600, 396);

        Label logo = new Label(background, SWT.NONE);
        logo.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
        logo.setImage(SWTResourceManager.getImage("C:\\Users\\al5an\\Desktop\\iau\\\u0645\u0646\u0635\u0629 \u0643\u0627\u0641.jpg"));
        logo.setBounds(107, 27, 418, 261);

        Button searchButton = new Button(background, SWT.NONE);
        searchButton.setFont(SWTResourceManager.getFont("B Badr", 12, SWT.NORMAL));
        searchButton.setBounds(136, 309, 131, 49);
        searchButton.setText("\u0627\u0644\u0628\u062D\u062B");

        Button signInButton = new Button(background, SWT.NONE);
        signInButton.setFont(SWTResourceManager.getFont("B Badr", 12, SWT.NORMAL));
        signInButton.setText("\u062A\u0633\u062C\u064A\u0644 \u0627\u0644\u062F\u062E\u0648\u0644");
        signInButton.setBounds(330, 309, 137, 49);

        Label label = new Label(background, SWT.NONE);
        label.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
        label.setForeground(SWTResourceManager.getColor(210, 105, 30));
        label.setFont(SWTResourceManager.getFont("B Badr", 12, SWT.NORMAL));
        label.setAlignment(SWT.CENTER);
        label.setBounds(136, 269, 331, 34);
        label.setText("\u0645\u0631\u062D\u0628\u0627\u064B \u0628\u0643\u0645 \u0641\u064A \u0645\u0646\u0635\u0629 \u0643\u0627\u0641!");

    }
}



--------------------------------------------------------end of a class
-----------------------------------------------------

package org.eclipse.wb.swt;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;

import java.awt.FlowLayout;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;
import javax.swing.border.MatteBorder;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLayeredPane;
import javax.swing.JInternalFrame;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.CardLayout;
import java.awt.BorderLayout;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;


import org.eclipse.swt.widgets.Text;

public class SignInFrame {

    protected Shell shell;
    private Text text;
    private Text text_1;

    /**
     * Launch the application.
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            SignInFrame window = new SignInFrame();
            window.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Open the window.
     */
    public void open() {
        Display display = Display.getDefault();
        createContents();
        shell.open();
        shell.layout();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }

    /**
     * Create contents of the window.
     */
    protected void createContents() {
        shell = new Shell();
        shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
        shell.setSize(603, 443);
        shell.setText("تسجيل الدخول");

        Label label = new Label(shell, SWT.CENTER);
        label.setForeground(SWTResourceManager.getColor(210, 105, 30));
        label.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
        label.setFont(SWTResourceManager.getFont("Source Code Pro", 12, SWT.BOLD));
        label.setBounds(111, 113, 347, 34);
        label.setText("..سجلي دخولك من هنا..");

        text = new Text(shell, SWT.BORDER);
        text.setBounds(111, 164, 247, 24);

        Label label_1 = new Label(shell, SWT.NONE);
        label_1.setAlignment(SWT.RIGHT);
        label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
        label_1.setFont(SWTResourceManager.getFont("Source Code Pro", 10, SWT.NORMAL));
        label_1.setBounds(364, 167, 94, 24);
        label_1.setText("اسم المستخدم");

        Label label_2 = new Label(shell, SWT.NONE);
        label_2.setAlignment(SWT.RIGHT);
        label_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
        label_2.setFont(SWTResourceManager.getFont("Source Code Pro", 10, SWT.NORMAL));
        label_2.setBounds(364, 206, 94, 24);
        label_2.setText("الرقم السري");

        text_1 = new Text(shell, SWT.BORDER);
        text_1.setBounds(111, 206, 247, 24);

        Button button = new Button(shell, SWT.NONE);
        button.setFont(SWTResourceManager.getFont("Source Code Pro", 10, SWT.BOLD));
        button.setBounds(111, 260, 85, 26);
        button.setText("دخول");

        Label label_3 = new Label(shell, SWT.NONE);
        label_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
        label_3.setFont(SWTResourceManager.getFont("Source Code Pro", 9, SWT.ITALIC));
        label_3.setBounds(111, 306, 347, 24);
        label_3.setText("في حال نسيتِ الرقم السري، نرجو التواصل مع وحدة الأنشطة في الكلية");

        Label lblNewLabel = new Label(shell, SWT.NONE);
        lblNewLabel.setBounds(0, 0, 607, 50);
        lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
        lblNewLabel.setImage(SWTResourceManager.getImage("C:\\Users\\al5an\\Desktop\\iau\\KaffPlatformheader.jpg"));

    }
}



-----------------------------end of a class 
----------------------------------------------------------------------

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.custom.ScrolledComposite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Control;


import org.eclipse.swt.graphics.Point;

public class AddBookKAff {

    protected Shell shell;
    private Text text;
    private Text text_1;
    private Text text_2;
    private Text text_3;
    private Text text_4;
    private Text text_5;
    private Text text_6;

    /**
     * Launch the application.
     *
     * @param args
     */
    public static void main(String[] args) {
        try {
            AddBookKAff window = new AddBookKAff();
            window.open();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Open the window.
     */
    public void open() {
        Display display = Display.getDefault();
        createContents();
        shell.open();
        shell.layout();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
    }

    /**
     * Create contents of the window.
     */
    protected void createContents() {
        shell = new Shell();
        shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
        shell.setSize(599, 779);
        shell.setText("إضافة كتاب جديد");

        Label label = new Label(shell, SWT.NONE);
        label.setImage(SWTResourceManager.getImage("C:\\Users\\al5an\\Desktop\\iau\\KaffPlatformheader.jpg"));
        label.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
        label.setBounds(0, 0, 607, 50);

        Label label_1 = new Label(shell, SWT.NONE);
        label_1.setFont(SWTResourceManager.getFont("B Badr", 14, SWT.NORMAL));
        label_1.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
        label_1.setAlignment(SWT.CENTER);
        label_1.setBounds(184, 70, 181, 38);
        label_1.setText("إضافة كتاب جديد");

        Label label_2 = new Label(shell, SWT.NONE);
        label_2.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
        label_2.setForeground(SWTResourceManager.getColor(210, 105, 30));
        label_2.setFont(SWTResourceManager.getFont("B Badr", 12, SWT.BOLD));
        label_2.setAlignment(SWT.CENTER);
        label_2.setBounds(177, 130, 192, 28);
        label_2.setText("معلومات الكتاب");

        Label label_3 = new Label(shell, SWT.NONE);
        label_3.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
        label_3.setFont(SWTResourceManager.getFont("B Badr", 12, SWT.NORMAL));
        label_3.setBounds(415, 203, 119, 28);
        label_3.setText("عنوان الكتاب");

        text = new Text(shell, SWT.BORDER);
        text.setBounds(56, 206, 334, 24);

        Label label_4 = new Label(shell, SWT.NONE);
        label_4.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
        label_4.setFont(SWTResourceManager.getFont("B Badr", 12, SWT.NORMAL));
        label_4.setBounds(415, 170, 119, 32);
        label_4.setText("رمز الكتاب");

        Label label_5 = new Label(shell, SWT.NONE);
        label_5.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
        label_5.setBounds(321, 175, 69, 21);
        label_5.setText("23103");

        Label lblNewLabel = new Label(shell, SWT.NONE);
        lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
        lblNewLabel.setFont(SWTResourceManager.getFont("B Badr", 12, SWT.NORMAL));
        lblNewLabel.setBounds(415, 235, 119, 28);
        lblNewLabel.setText("إصدار الكتاب");

        text_1 = new Text(shell, SWT.BORDER);
        text_1.setBounds(271, 240, 119, 24);

        Label label_6 = new Label(shell, SWT.NONE);
        label_6.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
        label_6.setFont(SWTResourceManager.getFont("B Badr", 12, SWT.NORMAL));
        label_6.setText("المستوى");
        label_6.setBounds(415, 269, 119, 27);

        Combo combo = new Combo(shell, SWT.NONE);
        combo.setItems(new String[]{"3", "4", "5", "6", "7", "8", "9", "10"});
        combo.setBounds(326, 272, 64, 25);
        combo.select(0);

        Label label_7 = new Label(shell, SWT.NONE);
        label_7.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
        label_7.setFont(SWTResourceManager.getFont("B Badr", 12, SWT.NORMAL));
        label_7.setText("السعر");
        label_7.setBounds(415, 351, 119, 28);

        Group group = new Group(shell, SWT.NONE);
        group.setBounds(56, 320, 334, 24);

        Button button = new Button(group, SWT.RADIO);
        button.setFont(SWTResourceManager.getFont("B Badr", 12, SWT.NORMAL));
        button.setBounds(21, 0, 73, 21);
        button.setText("مجاناً");

        Button button_1 = new Button(group, SWT.RADIO);
        button_1.setFont(SWTResourceManager.getFont("B Badr", 12, SWT.NORMAL));
        button_1.setBounds(130, 0, 73, 21);
        button_1.setText("إعارة");

        Button button_2 = new Button(group, SWT.RADIO);
        button_2.setFont(SWTResourceManager.getFont("B Badr", 12, SWT.NORMAL));
        button_2.setBounds(233, 0, 80, 21);
        button_2.setText("للبيع");

        text_2 = new Text(shell, SWT.BORDER);
        text_2.setBounds(326, 355, 64, 24);

        Label label_8 = new Label(shell, SWT.NONE);
        label_8.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
        label_8.setForeground(SWTResourceManager.getColor(210, 105, 30));
        label_8.setFont(SWTResourceManager.getFont("B Badr", 12, SWT.BOLD));
        label_8.setText("معلومات صاحبة الكتاب");
        label_8.setAlignment(SWT.CENTER);
        label_8.setBounds(147, 400, 242, 28);

        Label label_9 = new Label(shell, SWT.NONE);
        label_9.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
        label_9.setFont(SWTResourceManager.getFont("B Badr", 12, SWT.NORMAL));
        label_9.setBounds(415, 441, 119, 34);
        label_9.setText("الرقم الأكاديمي");

        text_3 = new Text(shell, SWT.BORDER);
        text_3.setBounds(204, 444, 186, 24);

        Label label_10 = new Label(shell, SWT.NONE);
        label_10.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
        label_10.setFont(SWTResourceManager.getFont("B Badr", 12, SWT.NORMAL));
        label_10.setBounds(415, 479, 119, 38);
        label_10.setText("مستخدم جديد؟ ");

        Group group_1 = new Group(shell, SWT.NONE);
        group_1.setBounds(204, 486, 186, 21);

        Button button_4 = new Button(group_1, SWT.RADIO);
        button_4.setFont(SWTResourceManager.getFont("B Badr", 12, SWT.NORMAL));
        button_4.setBounds(96, 0, 62, 21);
        button_4.setText("لا");

        Button button_3 = new Button(group_1, SWT.RADIO);
        button_3.setLocation(10, 0);
        button_3.setSize(62, 21);
        button_3.setFont(SWTResourceManager.getFont("B Badr", 12, SWT.NORMAL));
        button_3.setText("نعم");
        group_1.setTabList(new Control[]{button_3, button_4});

        Label label_11 = new Label(shell, SWT.NONE);
        label_11.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
        label_11.setFont(SWTResourceManager.getFont("B Badr", 12, SWT.NORMAL));
        label_11.setBounds(415, 516, 119, 28);
        label_11.setText("الاسم الثلاثي");

        text_4 = new Text(shell, SWT.BORDER);
        text_4.setBounds(56, 520, 334, 24);

        Label label_12 = new Label(shell, SWT.NONE);
        label_12.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
        label_12.setFont(SWTResourceManager.getFont("B Badr", 12, SWT.NORMAL));
        label_12.setText("رقم الجوال");
        label_12.setBounds(415, 550, 119, 27);

        text_5 = new Text(shell, SWT.BORDER);
        text_5.setBounds(204, 556, 186, 24);

        Label label_13 = new Label(shell, SWT.NONE);
        label_13.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
        label_13.setFont(SWTResourceManager.getFont("B Badr", 12, SWT.NORMAL));
        label_13.setBounds(415, 583, 119, 31);
        label_13.setText("المستوى");

        Combo combo_1 = new Combo(shell, SWT.NONE);
        combo_1.setItems(new String[]{"3", "4", "5", "6", "7", "8", "9", "10"});
        combo_1.setBounds(326, 589, 64, 25);
        combo_1.select(0);

        Label label_14 = new Label(shell, SWT.NONE);
        label_14.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
        label_14.setFont(SWTResourceManager.getFont("B Badr", 12, SWT.NORMAL));
        label_14.setBounds(415, 618, 119, 38);
        label_14.setText("البريد الإلكتروني");

        text_6 = new Text(shell, SWT.BORDER);
        text_6.setBounds(56, 621, 334, 24);

        Button button_5 = new Button(shell, SWT.NONE);
        button_5.setFont(SWTResourceManager.getFont("B Badr", 12, SWT.NORMAL));
        button_5.setBounds(54, 666, 85, 26);
        button_5.setText("إضافة");

        JButton button_6 = new Button(shell, SWT.NONE);
        button_6.setFont(SWTResourceManager.getFont("B Badr", 12, SWT.NORMAL));
        button_6.setBounds(150, 666, 85, 26);
        button_6.setText("رجوع");

    }
}
