package edu.tjdz.blog.service.sensitive;

import com.github.houbb.sensitive.word.api.IWordDeny;
import com.github.houbb.sensitive.word.bs.SensitiveWordBs;
import com.github.houbb.sensitive.word.support.allow.WordAllows;
import com.github.houbb.sensitive.word.support.deny.WordDenys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SensitiveWordConfig {

    @Autowired
    private IWordDeny myWordDeny;

    @Bean
    public SensitiveWordBs sensitiveWordBs(){
        SensitiveWordBs sensitiveWordBs = SensitiveWordBs.newInstance()
                .init().wordDeny(WordDenys.chains(WordDenys.system(),myWordDeny))
                .wordAllow(WordAllows.system());

        return sensitiveWordBs;

    }

}
