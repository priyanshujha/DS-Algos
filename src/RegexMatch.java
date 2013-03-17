import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexMatch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String rawInput="@priyanshu_jha RT 1234-jha-kumar my pic.twitter.com/352P5WATTG name is http://kafila.org/2013/03/02/kai-12kai-che-and-the-reduction-of-2002-zahir-janmohamed/#comment-47277 … @rajesh http://dfnksdnfks";		
		
		Pattern pattern=Pattern.compile("@\\w+");
		Matcher matcher=pattern.matcher(rawInput);		
		while(matcher.find())
		{
			rawInput=rawInput.replace(matcher.group(),"");
		}
		pattern=Pattern.compile("RT");
		matcher=pattern.matcher(rawInput);	
		String urlEx="[A-Z|a-z|0-9|\"|/|[..]+-[..]+|_|#|^|.|?|*|+|(|)]";
		while(matcher.find())
		{
			rawInput=rawInput.replace(matcher.group(),"");
		}
		String urlPattern="(http://|https://)"+urlEx+"+";
		pattern=Pattern.compile(urlPattern);
		matcher =pattern.matcher(rawInput);
		while(matcher.find())
		{
			rawInput=rawInput.replace(matcher.group(),"");
		}
		urlPattern=urlEx+"+(.org|.com)"+urlEx+"*";
		pattern=Pattern.compile(urlPattern);
		matcher =pattern.matcher(rawInput);
		while(matcher.find())
		{
			rawInput=rawInput.replace(matcher.group(),"");
		}
		System.out.println(rawInput);
		/*
		String test="priyanshu jha #IsAGoodBoy in #IAmDoingWorkshop #microsoft #Apple #inFairyLand singapore";
		Pattern pattern=Pattern.compile("#\\w+");
		Matcher matcher=pattern.matcher(test);		
		while(matcher.find())
		{
			String matchedString=matcher.group();
			String matchedTrimmedString=matchedString.substring(1);			
			Pattern newPattern=Pattern.compile("[A-Z|a-z][a-z|0-9]*");
			Matcher newMatcher=newPattern.matcher(matchedTrimmedString);
			String replacementString="";
			while(newMatcher.find())
			{
				replacementString+=newMatcher.group()+" ";				
			}
			replacementString.trim();		
			test=test.replace(matchedString, replacementString);
		}
		System.out.println(test);
		*/

	}

}
