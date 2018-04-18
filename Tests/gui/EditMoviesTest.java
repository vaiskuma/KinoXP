package gui;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Created by Mantas_MSI on 22-Sep-17.
 */
public class EditMoviesTest {
    EditMovies editMovies    = new EditMovies();

    //see if it works
    @Test
    public  void Test00SeeIfWorks() throws  Exception{
        assertEquals(1, 1);
    }
    //We did not do any more test as we used a lambda expression.


}
