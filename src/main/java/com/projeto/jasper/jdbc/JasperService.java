package com.projeto.jasper.jdbc;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class JasperService {

    private Map<String, Object> params = new HashMap<>();

    public void addParams(String key, Object value) {
        this.params.put(key, value);
    }

    private JasperReport compilarJrxml(String arquivo) {

        try {
            InputStream is = getClass().getClassLoader().getResourceAsStream(arquivo);
            return JasperCompileManager.compileReport(is);
        } catch (JRException e) {
            e.printStackTrace();
        }
        return null;
    }

}
