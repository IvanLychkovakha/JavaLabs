package Task4;

import java.io.File;

public class DirTree {
    public static void list(String Dir){
        File f =new File(Dir);
        String[] DirList = f.list();
        for(int i = 0; i < DirList.length; i++)
        {
            File f1 = new File(Dir +
                    File.separator + DirList[i]);

            if(f1.isFile())
                System.out.println(Dir +
                        File.separator + DirList[i]);
            else
            {
                list(Dir +
                        File.separator + DirList[i]);
            }
        }
    }

}
