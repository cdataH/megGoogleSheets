package com.cdatatest.googlesheets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import javax.sql.DataSource;

public class DriverManagerDataSource{

    private static Environment env;

    @Bean(name ="GoogleSheets")
    @Primary
    public static DataSource GoogleSheetsDataSource()
    {

        DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("cdata.jdbc.googlesheets.GoogleSheetsDriver");
        dataSourceBuilder.url("jdbc:googlesheets:" +
                "AuthScheme=OAuth;" +
//                "Spreadsheet=sample_sheet1;" +
                "InitiateOAuth=GETANDREFRESH;" +
                "SSLServerCert=*;ProxyServer=127.0.0.1;ProxyPort=8888;" +
                "_persist_oauthrefreshtoken=1//01-c90Mb82PGdCgYIARAAGAESNwF-L9Ir_Ar7WkCHXRTz2BXRsm5qSDMHZIHgQ_HZ06YWNLoeygsGFpn_XUaG7gu1O7pfSkctHuw;" +
                "_persist_oauthexpiresin=3599;" +
                "_persist_oauthaccesstoken=ya29.a0AVvZVsp5qMiV9ieS1V468bZemYyziLw-0vid3B4OH83aRVzFk2n-Uxz3DdOZtePoj4cnpNa15mtWCaH9zYTf1f_nwoa3x6Vp7vSgmQBLZYl0PdqvyKyJb-KkX1lz-Ch6cSDDtp7Bt7VckjkZa9wZhZaW8zf3uKVTVQaCgYKAXgSAQASFQGbdwaIychiAs26xLwYCUfJ3j-0GQ0169;" +
                "_persist_oauthtokentimestamp=1676547382760;");
        return dataSourceBuilder.build();
    }

    //@Override
    public void setEnvironment( final Environment environment) {
        env=environment;
    }
}