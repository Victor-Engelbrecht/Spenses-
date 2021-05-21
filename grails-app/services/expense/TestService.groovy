package expense

//used in tutorial
import grails.config.Config
import grails.core.support.GrailsConfigurationAware
import groovy.transform.CompileDynamic
import groovy.transform.CompileStatic
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.BlockingHttpClient
import io.micronaut.http.client.HttpClient
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.http.uri.UriBuilder
import org.grails.web.json.JSONObject

import grails.gorm.transactions.Transactional

class TestService implements GrailsConfigurationAware{

    def serviceMethod() {

    }

    String apikey
    BlockingHttpClient client

    //Gets the data in the application.yml file and sets needed variables
    @Override
    void setConfiguration(Config co) {
        setupHttpClient(co.getProperty('CurrencyConversion.url', String, 'http://data.fixer.io'))
        apikey = co.getProperty('CurrencyConversion.apikey', String)
    }


   void setupHttpClient(String url) {
        this.client = HttpClient.create(url.toURL()).toBlocking()
   }

   /*CurrencyConversion currencyConversion(Float aFloat) {

       //add your code here

       def currencyConversion = new CurrencyConvertion()
       currencyConversion.usValue = 1.23f
       currencyConversion.zaValue = 2.34f

       currencyConversion
   }*/

   /*CurrencyConversion getData() {
        try {
            HttpRequest request = HttpRequest.GET(currencyConversionUri())
            return client.retrieve(request, CurrencyConversion)

        } catch (HttpClientResponseException e) {
            return null
        }
   }*/

   URI currencyConversionUri() {
       UriBuilder uriBuilder = UriBuilder.of('/api/latest')
               .queryParam('q')
               .queryParam('access_key', apikey)
       uriBuilder.build()
   }
}
