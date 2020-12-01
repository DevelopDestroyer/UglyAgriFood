package com.ugly.agri.service

import org.springframework.util.ResourceUtils
import spock.lang.Specification

class FileServiceTest extends Specification {
    def "리소스 경로 확인"() {
        given:
        String localPath = "classpath:static/img/product"
        String serverPath = "/opt/uglyAgriFood/img"

        when:
        println ResourceUtils.getFile(localPath).getAbsolutePath()
        println ResourceUtils.getFile(serverPath).getAbsolutePath()

        then:
        noExceptionThrown()
    }

    def "경로 자르기"() {
        given:
        String path = "classpath:static/img/product"

        when:
        String res = path.substring(path.indexOf("/"))

        then:
        res == "/img/product"
    }
}
