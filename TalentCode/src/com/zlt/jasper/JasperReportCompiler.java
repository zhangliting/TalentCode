package com.zlt.jasper;

import net.sf.jasperreports.engine.JasperCompileManager;

/**
 * You'll need these jar's below:
 *
 * jasperreports-5.0.1.jar iText-2.1.7.jar (needed to generate PDF) jfreechart-1.0.12.jar (needed to graphics and
 * charts) jcommon-1.0.15.jar (needed to graphics and charts) commons-beanutils-1.8.2.jar commons-collections-3.2.1.jar
 * commons-digester-2.1.jar commons-logging-1.1.jar
 */
public class JasperReportCompiler {

    public static void main(String[] args) {

        int count = args.length;
        try {
            if (count > 0) {
                String reportName = args[0];
                String str[] = reportName.split("\\.");
                String reportName_jasper = str[0] + ".jasper";
                JasperCompileManager.compileReportToFile(reportName, reportName_jasper);
            }

        } catch (Exception e) {
//            throw new RuntimeException("It's not possible to generate the jasper report.", e);
            e.printStackTrace();
        }

    }

}
