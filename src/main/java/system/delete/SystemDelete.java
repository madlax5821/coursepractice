package system.delete;

import java.io.File;

public class SystemDelete {
    public static void main(String[] args) {
        String str = "/home/madlax/IdeaProjects/my-project";
        //delete(str);
    }

    private static void delete(String filePath){
        File file = new File(filePath);
        File[] files = file.listFiles();
        for (File f:files){
            if(!f.isFile()){
                delete(f.getAbsolutePath());
            }
            f.delete();
        }
        file.delete();
    }

    private static boolean ifPalindrome(String text){
        String temp = getString(text);
        return temp.equals(text);
    }

    private static String getString(String text) {
        if (text==null||text.isEmpty()){
            return "";
        }
        return text.charAt(text.length()-1)+getString(text.substring(0,text.length()-1));
    }

}
