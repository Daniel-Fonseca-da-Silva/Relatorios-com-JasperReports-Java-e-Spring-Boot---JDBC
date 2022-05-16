package com.projeto.jasper.jdbc;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;

import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

public class JasperService {

    private Map<String, Object> params = new HashMap<>();

    public void addParams(String key, Object value) {
        this.params.put(key, value);
    }

    public void AbrirJasperViewer(String jrxml, Connection connection) {
        JasperReport report = compilarJrxml(jrxml);
        try {
            JasperPrint print = JasperFillManager.fillReport(report, this.params, connection);
            JasperViewer viewer = new JasperViewer(print);
            viewer.setVisible(true);
        } catch (JRException e) {
            e.printStackTrace();
        }
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
