package com.example.mbti.Service;

import com.example.mbti.Domain.Mbti;
import com.example.mbti.Repository.MbtiRepository;
import com.example.mbti.Req.MbtiInsert;
import com.example.mbti.Res.MbtiRes;
import org.springframework.stereotype.Service;

import java.nio.channels.IllegalChannelGroupException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MbtiService {

    public static String arr[] = {"ENFJ", "ENFP", "ESTJ", "ESFJ", "ENTJ", "ENTP", "ESTP", "ESFP", "INFJ", "INFP", "ISTJ", "ISFJ", "INTJ", "INTP", "ISTP", "ISFP"};
    private final MbtiRepository mbtiRepository;

    public MbtiService(MbtiRepository mbtiRepository){
        this.mbtiRepository = mbtiRepository;
    }

    public void saveMbti(String mbtiw, String info){
        //req.getMbti()에서 16가지 mbti에 해당하지 않는 문자열 예외 처리 진행
        /*
        int count = 0;

        for(int i=0; i<16; i++){
            if(mbtiw == arr[i])
                count++;
        }

        if(count==0){
            //HTTP STATUS 보내야 함
        }
        else{
            mbtiRepository.save(new Mbti(mbtiw, info));
        }
*/
        mbtiRepository.save(new Mbti(mbtiw, info));

    }


    public List<MbtiRes> getMbtis(){
        return mbtiRepository.findAll().stream()
                .map(MbtiRes::new)
                .collect(Collectors.toList());
    }

    public Mbti getMbti(String mbtiw){

        List<Mbti> mbtis = mbtiRepository.findAllByMbtiw(mbtiw);

        if(mbtis.size()>1){
            int a = mbtis.size();

            int randomVal = (int)(Math.random() * a);

            return mbtis.get(randomVal);
        }

        return mbtis.get(0);
    }


}
