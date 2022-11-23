
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;

public class test_api {

    public static void main(String[] args) 
    {
        String api_key = "980d96176457a6e65b8bc282bcadccd4";
        String cat = "Action";
        long id2 = 28;
        try
        {
            HttpResponse<String> res = Unirest.get("https://api.themoviedb.org/3/discover/"+cat+"?api_key="+api_key+"&language=en-US&sort_by=popularity.desc&include_adult=false&include_video=false&page=1&primary_release_date.gte=1990-01-01&primary_release_date.lte=2022-12-31&vote_average.gte=6&with_genres="+id2).asString();
            if(res.getStatus()==200)
            {
                String r = res.getBody();
                System.out.println("JASN    "+r);
            }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
    }
}
