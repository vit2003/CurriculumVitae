/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vinhlp.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 *
 * @author Asus
 */
public class LoadFileSupport implements Serializable{
    public static HashMap<String, String> getMap(File file) throws FileNotFoundException, IOException {
        HashMap<String, String> result = new HashMap<>();
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line;
        while ((line = br.readLine()) != null){
            StringTokenizer stk = new StringTokenizer(line,"=");
            while (stk.hasMoreTokens()){
                String key = stk.nextToken().trim();
                String value = stk.nextToken().trim();
                result.put(key, value);
            }
        }
        return result;
    }
}
