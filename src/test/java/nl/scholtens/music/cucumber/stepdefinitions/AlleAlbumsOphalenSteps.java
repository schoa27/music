package nl.scholtens.music.cucumber.stepdefinitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import nl.scholtens.music.cucumber.MusicFeatureTest;
import nl.scholtens.music.domain.Album;
import nl.scholtens.music.services.AlbumService;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

public class AlleAlbumsOphalenSteps extends MusicFeatureTest {

    @Autowired
    private AlbumService service;

    private List<Album> albums;


    @Given("^Haal alle albums op uit de database met of zonder filter$")
    public void haalAlleAlbumsOpUitDeDatabaseMetOfZonderFilter() throws Throwable {
        albums = service.getAllAlbums("", false);
    }

    @When("^Naam filter met \"([^\"]*)\" is ingevuld$")
    public void naamFilterMetIsIngevuld(String arg1) throws Throwable {
        Album name = service.getAlbumByName("name");
    }

    @When("^Tietel filter met \"([^\"]*)\" is ingevuld$")
    public void tietelFilterMetIsIngevuld(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("^Jaartal filter met \"([^\"]*)\" is ingevuld$")
    public void jaartalFilterMetIsIngevuld(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @Then("^Album lijst bevat  albums$")
    public void albumLijstBevatAlbums() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }


}
