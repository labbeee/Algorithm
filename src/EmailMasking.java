public class EmailMasking {
    public static String maskEmail(String email) {
        if (email == null || email.isEmpty()) {
            return email;
        }

        int atIndex = email.indexOf('@');
        if (atIndex < 0) {
            return email;
        }

        String username = email.substring(0, atIndex);
        String domain = email.substring(atIndex);

        // 脱敏处理用户名
        int usernameLength = username.length();
        if (usernameLength <= 2) {
            username = "*";
        } else if (usernameLength <= 5) {
            username = username.charAt(0) + "*" + username.charAt(usernameLength - 1);
        } else {
            int maskLength = usernameLength - 2;
            StringBuilder sb = new StringBuilder();
            sb.append(username.charAt(0));
            for (int i = 0; i < maskLength; i++) {
                sb.append("*");
            }
            sb.append(username.charAt(usernameLength - 1));
            username = sb.toString();
        }

        // 返回脱敏后的邮箱
        return username + domain;
    }

    public static void main(String[] args) {
        String email = "example@example.com";
        String maskedEmail = maskEmail(email);
        System.out.println("原始邮箱：" + email);
        System.out.println("脱敏后邮箱：" + maskedEmail);
    }
}