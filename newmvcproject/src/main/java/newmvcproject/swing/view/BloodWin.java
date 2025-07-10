package newmvcproject.swing.view;

import java.awt.*;
import javax.swing.*;

public class BloodWin extends JFrame {
    JComboBox<String> box;
    JButton button;

    public BloodWin() {
        // Look and Feel 적용
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println("Look and Feel 설정 실패: " + e);
        }

        // 컴포넌트 생성
        box = new JComboBox<>();
        button = new JButton("결과 보기");

        // 데이터 채우기
        box.addItem("A");
        box.addItem("B");
        box.addItem("O");
        box.addItem("AB");

        // 스타일 설정
        box.setPreferredSize(new Dimension(180, 30));
        button.setPreferredSize(new Dimension(120, 30));

        // 색상 변경 (민트 스타일)
        Color mint = new Color(102, 204, 204);       // 버튼 민트색
        Color mintBackground = new Color(240, 255, 255); // 전체 배경 민트빛 흰색

        button.setBackground(mint);
        button.setForeground(Color.white);
        button.setFocusPainted(false);

        Font font = new Font("맑은 고딕", Font.PLAIN, 14);
        box.setFont(font);
        button.setFont(font);

        // 패널로 그룹화
        JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
        centerPanel.setBackground(mintBackground);
        centerPanel.add(box);
        centerPanel.add(button);

        button.addActionListener((e) -> {
            getAdvice();
        });

        // 프레임 설정
        add(centerPanel, BorderLayout.CENTER);
        setTitle("혈액형 선택기");
        setSize(300, 180);
        setLocationRelativeTo(null); // 화면 중앙
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void getAdvice() {
        String item = (String) box.getSelectedItem();
        String msg = "";
        if (item == null) item = "";

        if (item.equals("A")) {
            msg = "신중하고 꼼꼼하다";
        } else if (item.equals("B")) {
            msg = "자유롭고 개성 강함";
        } else if (item.equals("O")) {
            msg = "외향적이고 리더십이 있다.";
        } else if (item.equals("AB")) {
            msg = "이성적이고 독특하다";
        }

        JOptionPane.showMessageDialog(this, msg, "성격 분석", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        new BloodWin();
    }
}
