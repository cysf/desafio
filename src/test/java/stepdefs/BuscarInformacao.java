package stepdefs;

import cucumber.api.java.es.Dado;
import cucumber.api.java.pt.Então;
import cucumber.api.java.pt.Quando;
import static org.junit.Assert.*;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class BuscarInformacao {
    private WebDriver navegador;
    private WebDriverWait espera;

    @Dado("^que acesso o site da getnet$")
    public void que_acesso_o_site_da_getnet() throws Throwable {
        System.setProperty("webdriver.chrome.driver", "C:\\Windows\\chromedriver.exe");

        navegador = new ChromeDriver();
        navegador.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        navegador.manage().window().maximize();
        navegador.get("https://site.getnet.com.br/");
        espera = new WebDriverWait(navegador,20);
    }

    @Quando("^faço a pesquisa de \"([^\"]*)\"$")
    public void faço_a_pesquisa_de(String arg1) throws Throwable {
        Thread.sleep(5000); //sei que existem os implicity e explicity waits, mas não funcionaram :(

        WebElement lupa = navegador.findElement(By.id("search-trigger"));
        lupa.click();

        WebElement busca = navegador.findElement(By.id("global-search-input"));
        busca.sendKeys("superget");

        navegador.findElement(By.xpath("//button[@type=\"submit\"]")).click();

        navegador.findElement(By.xpath("//h3[text()=\"Como faço a portabilidade da minha maquininha?\"]")).click();
    }

    @Então("^devo visualizar a mensagem \"([^\"]*)\"$")
    public void devo_visualizar_a_mensagem(String arg1) throws Throwable {
        String titulo = navegador.findElement(By
                .xpath("//div[text()=\"Como faço a portabilidade da minha maquininha?\"]"))
                .getText();
        assertEquals("Como faço a portabilidade da minha maquininha?",titulo);
    }

    @After
    public void tearDown() {
        navegador.quit();
    }
}
