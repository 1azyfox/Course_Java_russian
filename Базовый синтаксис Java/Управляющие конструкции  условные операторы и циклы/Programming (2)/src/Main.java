private String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < roles.length; i++) {
        sb.append(roles[i] + ":" + "\n");
        for (int j = 0; j < textLines.length; j++) {
        String roles1 = roles[i] + ':';
        if (textLines[j].startsWith(roles1)) {
        StringBuilder sb1 = new StringBuilder(textLines[j]);
        sb1.delete(0, roles[i].length() + 1);
        sb.append((j + 1) + ")" + sb1 + "\n");
        }
        }
        sb.append("\n");
        }
        return sb.toString();
        }