package com.paterns.generator.generators;

import com.paterns.generator.model.Singleton;
import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class SingletonGenerator {





    public void generateSingleton(Singleton singleton)throws IOException {
        String singletonTemplate;
        Reader reader = new FileReader("resources/SingletonTemplate");
        BufferedReader br = new BufferedReader(reader);
        String line;
        FileWriter writer = new FileWriter("SingletonTemplate.txt", true);
        try{
            while((line = br.readLine()) != null ){
              if(line.contains("#NameSingleton#")){
                  line.replaceAll("#NameSingleton#", singleton.getName());
              }
              writer.write(line);
            }
            reader.close();
            br.close();


        }catch(IOException e){
            e.printStackTrace();
        }


    }

}
