<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 등록 성공</title>
<style>
    body {
        margin: 0;
        padding: 0;
        font-family: 'Segoe UI', sans-serif;
        background: linear-gradient(135deg, #d4fc79, #96e6a1);
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        animation: fadeIn 1s ease forwards;
    }

    .success-box {
        background: white;
        padding: 40px 50px;
        border-radius: 16px;
        box-shadow: 0 8px 24px rgba(0, 0, 0, 0.15);
        text-align: center;
        animation: slideUp 0.8s ease-out forwards;
        opacity: 0;
        transform: translateY(30px);
    }

    .success-box h1 {
        color: #2ecc71;
        font-size: 28px;
        margin-bottom: 12px;
    }

    .success-box p {
        font-size: 18px;
        color: #555;
        margin-top: 0;
    }

    .success-box button {
        margin-top: 20px;
        padding: 12px 24px;
        font-size: 16px;
        border: none;
        border-radius: 8px;
        background-color: #2ecc71;
        color: white;
        cursor: pointer;
        transition: background-color 0.3s ease, transform 0.2s ease;
    }

    .success-box button:hover {
        background-color: #27ae60;
        transform: scale(1.03);
    }

    @keyframes slideUp {
        to {
            opacity: 1;
            transform: translateY(0);
        }
    }

    @keyframes fadeIn {
        from {
            background-color: #ffffff;
        }
        to {
            background: linear-gradient(135deg, #d4fc79, #96e6a1);
        }
    }
</style>
</head>
<body>
    <div class="success-box">
        <h1>🎉 사원 등록 완료!</h1>
        <p>등록이 성공적으로 처리되었습니다.</p>
        <button onclick="location.href='/shop/notice/list'">목록으로 가기</button>
    </div>
</body>
</html>
