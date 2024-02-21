import java.util.ArrayList;
import java.util.HashMap;

public class Test {
	static ArrayList<String> characterExist = new ArrayList<>();
    public static int countVietnameseLetters(String inputString) {
        HashMap<String, Character> vietnameseMapping = new HashMap<>();
       
        //Tạo ra 1 hashMap với các key là ký tự latin, value là các giá trị trong bảng chữ cái tiếng việt
        vietnameseMapping.put("aw", 'ă');
        vietnameseMapping.put("aa", 'â');
        vietnameseMapping.put("dd", 'đ');
        vietnameseMapping.put("ee", 'ê');
        vietnameseMapping.put("oo", 'ô');
        vietnameseMapping.put("ow", 'ơ');
        vietnameseMapping.put("w", 'ư');
        
        int count = 0;
        //Kiểm tra từ chữ cái đầu tiên
        int i = 0;
        while (i < inputString.length()) {
            boolean found = false;
            //Tại chữ cái đang xét, ta sẽ xét giá trị subString của chữ cái đó với chữ cái liền sau, nếu không có sẽ 
            //xét chính chữ cái đó.Trong trường hợp chữ cái đó ghép với chữ cạnh nó thành 1 từ trong tiếng việt thì ta sẽ bỏ qua
            //việc xét chính chữ cái đó cũng như là chữ cái cạnh nó. Ví dụ : nếu là awd....,khi ta xét chữ a,tức là i=0, với length = 2,
            //ta sẽ substring giá trị (0,2), tức là sẽ lấy 2 ký tự 0, 1, tức sẽ là ký tự aw
            //ở đây nó tạo thành chữ ă, khi đó ta sẽ không cần xét bản thân chữ a mà break ra khỏi vòng lặp luôn, đồng thời gán i+ = length
            //tức là giá trị i sẽ bỏ qua chữ w mà nhảy thẳng sang chữ d để xét tiếp
            for (int length = 2; length > 0; length--) {
                if (i + length <= inputString.length()) {
                    String substr = inputString.substring(i, i + length);
                    if (vietnameseMapping.containsKey(substr)) {
                    	characterExist.add(substr);
                        count++;
                        i += length;
                        found = true;
                        break;
                    }
                }
            }
            //Nếu xét cả chữ cạnh nó và bản thân nó không tạo thành từ có dấu, ta sẽ tăng i lên để xét chữ cái cạnh nó cho tới khi nào thực hiện hết chuỗi
            if (!found) {
                i++;
            }
        }
        return count;
    }
    public static String printString() {
    	String result = "";
    	for(String eachString : characterExist) {
    		result += eachString;
    		result += " ";
    	}
    	return result;
    }
    
    public static void main(String[] args) {
        String inputString = "hfdawhwhcoomdd";
        System.out.println("Output: " + countVietnameseLetters(inputString) + "(" + printString() + ")");
    }
}
