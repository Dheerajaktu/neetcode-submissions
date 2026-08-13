class Solution {

    /* Approach:: 
    Basically we need to find max area where we can store max water in b/w vertical lines or poles.   
    So we will take min vertical pol between two becuase water will fill till min height only.
    So that's why we will take height = Math.min(height[i], height[j]);
    Then we can find width simply find the diff b/w distance of two verticla poles.
    width = point of j = point of i;
    then we will find area using formula 
    Area = Widh * Height;
    And will store max area;
    And finallly our max Area would be container or empty area where we can store max water.
    so we found our answer. 
    HaPpY LeArNiNg!


 ==> हिन्दी में
    मूल रूप से हमें ऐसी दो ऊर्ध्वाधर रेखाएँ (Vertical Lines/Poles) ढूँढनी हैं, जिनके बीच अधिकतम पानी रखा जा सके।

    दो रेखाओं के बीच पानी की ऊँचाई हमेशा छोटी रेखा की ऊँचाई तक ही होगी।
    इसलिए: height = Math.min(height[i], height[j])
    दोनों रेखाओं के बीच की दूरी ही Width होगी। width = j - i
    अब क्षेत्रफल निकालेंगे: Area = Width × Height
    हर बार मिले हुए Area में से Maximum Area को store करते रहेंगे। 
    अंत में जो Maximum Area मिलेगा, वही हमारा answer होगा — अर्थात् वह container जो अधिकतम जल धारण कर सकता है।

    हैप्पी लर्निंग!


===> संस्कृत में
मूलतः अस्माभिः एतादृशे द्वे ऊर्ध्वाधर-रेखे अन्वेष्टव्ये, ययोः मध्ये अधिकतमं जलं स्थापयितुं शक्यते।
द्वयोः रेखयोः मध्ये जलस्य उच्चता लघुतर-रेखायाः उच्चतायाः एव भवति।
अतः: height = Math.min(height[i], height[j])
द्वयोः रेखयोः मध्यवर्ती दूरी एव Width भवति। width = j - i

ततः क्षेत्रफलम् ज्ञास्यामः: Area = Width × Height
प्रत्येकस्मिन् चरणे प्राप्तेषु क्षेत्रफलेषु अधिकतमं क्षेत्रफलम् संग्रहीष्यामः।
अन्ते यत् Maximum Area प्राप्यते, तत् एव अस्माकम् उत्तरम्। अर्थात् सः पात्रः अधिकतमं जलं धारयितुं शक्नोति।
सुखेन अधीयताम्! 
    */
    public int maxArea(int[] heights) {
        int n = heights.length; 
        int i = 0; 
        int j = n-1;
        int maxWaterContainer = 0;

        while(i < j){
            int w = j - i; // w ==> width

            int h = Math.min(heights[i], heights[j]); // taking least height from both

            int area = w * h;

            maxWaterContainer = Math.max(maxWaterContainer, area);

            if(heights[i] > heights[j]){
                j--;
            }else{
                i++;
            }
        }

        return maxWaterContainer;
    }
}
