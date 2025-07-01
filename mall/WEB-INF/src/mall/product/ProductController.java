package mall.product;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;

public class ProductController extends HttpServlet {
    String url = "jdbc:mysql://localhost:3306/shop";
    String user = "shop";
    String password = "12341234";

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();

        out.println("<h2>My name is yooshin park</h2>");
        out.println("<p>제 이름은 한국어로 박유신이라고 합니다.</p>");

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            out.println("드라이버 로드 성공<br>");

            con = DriverManager.getConnection(url, user, password);
            if (con != null) {
                out.println("접속 성공<br>");

                // StringBuffer 사용
                StringBuffer sql = new StringBuffer();
                sql.append("SELECT * FROM product");

                pstmt = con.prepareStatement(sql.toString());
                rs = pstmt.executeQuery();

                ArrayList<Product> list = new ArrayList<>();

                while (rs.next()) {
                    Product product = new Product();
                    product.setProduct_id(rs.getInt("product_id"));
                    product.setProduct_name(rs.getString("product_name"));
                    product.setBrand(rs.getString("brand"));
                    product.setPrice(rs.getInt("price"));
                    product.setDiscount(rs.getInt("discount"));
                    product.setIntroduce(rs.getString("introduce"));
                    product.setDetail(rs.getString("detail"));
                    list.add(product);
                }

                // HTML 테이블 출력
                out.println("<table border='1'>");
                out.println("<tr><th>ID</th><th>Name</th><th>Brand</th><th>Price</th><th>Discount</th><th>Intro</th><th>Detail</th></tr>");
                for (Product p : list) {
                    out.println("<tr>");
                    out.println("<td>" + p.getProduct_id() + "</td>");
                    out.println("<td>" + p.getProduct_name() + "</td>");
                    out.println("<td>" + p.getBrand() + "</td>");
                    out.println("<td>" + p.getPrice() + "</td>");
                    out.println("<td>" + p.getDiscount() + "</td>");
                    out.println("<td>" + p.getIntroduce() + "</td>");
                    out.println("<td>" + p.getDetail() + "</td>");
                    out.println("</tr>");
                }
                out.println("</table>");
            } else {
                out.println("접속 실패");
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            out.println("드라이버 로드 실패");
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("SQL 오류 발생");
        } finally {
            try { if (rs != null) rs.close(); } catch (SQLException ignored) {}
            try { if (pstmt != null) pstmt.close(); } catch (SQLException ignored) {}
            try { if (con != null) con.close(); } catch (SQLException ignored) {}
            out.close();
        }
    }
}
