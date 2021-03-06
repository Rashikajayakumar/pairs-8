/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package embeddedmediaplayer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author comqsjb
 */
public class ClipTest {
    
    public ClipTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTitle method, of class Clip.
     */
    @Test
    public void testSetTitleToEmptyStringKeepsPreviousValue()
    {
        System.out.println("setTitle");
         Clip instance = new Clip();
         String OriginalTitle = "Original Title";
        instance.setTitle(OriginalTitle);              
        String EmptyTitle = " ";
        instance.setTitle(EmptyTitle);              // try to set Empty Title
        String ModifiedTitle = instance.getTitle(); // check Empty Title is set or not 
         assertTrue(OriginalTitle.equals(ModifiedTitle));// compare original title and resulted title
         System.out.println("Empty Title is not set");
    }

    @Test
    public void testSetEndBeforeStartKeepsPreviousValue()
    {
         System.out.println("Doesn't allow to set end time to start time");
       Clip instance = new Clip();
         String OriginalTitle = "Sub video"; //Create sub video clip
         instance.setTitle(OriginalTitle);   // Set Title  
         int OriginalStartTime = 10; // sub video start time 
         int originalEndtime = 50;// sub video end time
         instance.setMax(100);//set master video to 100 seconds video
   // Create a new sub clip from 10th second to 50th second
         instance.setStart(OriginalStartTime);//Set start time to sub video from 10th sec 
         instance.setEnd(originalEndtime);// set end time to sub video at 50th second
         int CurrentStartTime = instance.getStart();
         int CurrentEndTime = instance.getEnd(); //Get endtime of the video       
         instance.setStart(CurrentEndTime); //try setting end time as start time to the sub clip  
         assertEquals(OriginalStartTime,CurrentStartTime);
         System.out.println("Start time is same as previous value");
    }

    @Test
    public void testEqualsOnEqualClips() 
    {
    //    create two sub videos with same title and same start time and end time
 //     2nd video should not allowed to be created due to duplicate
         System.out.println("multiple videos creation");
        String SubTitle1 = "Sub video 1"; //Create first sub video clip
         Clip subClip1 = new Clip(SubTitle1,5,40); // First sub clip
         
         Clip subClip2 = new Clip();// Second sub ciip
         String SubTitle2 = "Sub video 1"; //Create second sub video clip 
         subClip2.setTitle(SubTitle2);   // Set Title  
         subClip2.setStart(5);//Set start time to sub video from 5th sec 
         subClip2.setEnd(40);// set end time to sub video at 40th second
        
        boolean DuplicateClip = subClip1.equals(subClip2); 
       assertEquals(true,DuplicateClip); // its a duplicate video
        System.out.println("Duplicate video");  
    }
    
    @Test
    public void testEqualsOnNonEqualClips() 
    {
          //    create two sub videos with different title and same start time and end time
 //     check whether two clips are equal
         System.out.println("Equals On Non equal clip");
        String SubTitle1 = "Title1"; //Create first sub video clip
         Clip subClip1 = new Clip(SubTitle1,5,70); // First sub clip
         
         Clip subClip2 = new Clip();// Second sub clip
         String SubTitle2 = "Title 2"; //Create second sub video clip 
         subClip2.setTitle(SubTitle2);   // Set Title  
         subClip2.setStart(5);//Set start time  5 sec 
         subClip2.setEnd(70);// set end time 70 sec
        
        boolean ComparisonClip = subClip1.equals(subClip2); 
       assertNotEquals(true,ComparisonClip); // its a comparison  video
        System.out.println("Non equal clip found with different title"); 
    }
    
    @Test
    public void testSetEndToNegativeNumberKeepsPreviousValue() 
    {
       System.out.println("set Negative num to the end time of the clip");
       Clip clip = new Clip();
       String initialTitle = "clipOne";
       clip.setTitle(initialTitle); //set title 
       int ClipOneStartTime = 5; // start from 5th sec
       int ClipEndTime = 70; //end at 70th sec
       int ExpectEndTime = 70;
       //create a clip one 
       clip.setStart(ClipOneStartTime);
       clip.setEnd(ClipEndTime);
       // get current status of the clip
       int NegativeNumber = -1;  
       clip.setEnd(NegativeNumber); // set negative number as end time
       int ModifiedEndTime = clip.getEnd();
       assertEquals(ExpectEndTime,ModifiedEndTime);
       System.out.println("EndTimeisNotset as EndTime cannot be Negative");
    }
    
    @Test
    public void testSetStartToValidPositiveNumber() 
    {    
        System.out.println("set valid positive numbers");
        boolean PostiveFlag = false;
        Clip clip = new Clip();
        String InitialTitle = "ClipOne"; 
        clip.setTitle(InitialTitle); // set Title
        int ClipOneStartTime = 5; //Start from 5th sec
        int ClipOneEndTime =70; // End at 70th sec
        //create a ClipOne 
        clip.setStart(ClipOneStartTime);
        clip.setEnd(ClipOneEndTime);
        // Set positive number as start time 
        int PositiveNumber = 8;
        clip.setStart(PositiveNumber);// set positive number as start time 
        int ModifiedStartTime= clip.getStart();
        // Check start time is valid positive number 
        if(ModifiedStartTime>0)
        {
            PostiveFlag = true;
            assertEquals(true,PostiveFlag);
            System.out.println("Start time is valid positive number");
        }
        
    }
    
    
    
}
