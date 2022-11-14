/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package serVice;

import domainmodel.ChucVu;
import java.util.List;
import repository.ChucVuRepos;

/**
 *
 * @author ADMIN
 */
public class ChucVuservice {
    public static List<ChucVu> getAll(){
        return ChucVuRepos.getAll();
    }
    public static int them(ChucVu cv){
        return ChucVuRepos.them(cv);
    }
    public static ChucVu getByMa(String m){
        return ChucVuRepos.getByM(m);
    }
}
