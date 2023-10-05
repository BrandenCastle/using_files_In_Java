//Branden Castle


//import libraries
import java.io.*;
import java.io.FileNotFoundException;
import java.io.IOException;
public class cityfinder {
public static void main(String args[]) throws IOException {
// declare variables
int i = 0, p = 0, l = 0, ll = 0, j, t = 0, max = 0;
double hold, largest_num = 0, second = 0, closest = 0, largest_lat = 0,
largest_long = 0;
double longs[] = new double[1000], populations[] = new double[1000], lats[]
= new double[1000];
double dist[] = new double[1000];
String[] towns = new String[1000];
String words, words2, words3, largest_city = "", second_city = "", str,
closest_city = "";
try {// reads in file for cities
BufferedReader r1 = new BufferedReader(new FileReader("cities.txt"));
str = r1.readLine();
while (str != null) {// continues if there are still strings
towns[t] = str;// creates array for towns
str = r1.readLine();// reads the next line allowing loop to continue
t++;// counts up index
}
r1.close();// closes file
} catch (FileNotFoundException e) {// happens when file location cannot be found
System.out.println("File not found");
e.printStackTrace();
}
try {// reads in file for population
BufferedReader r2 = new BufferedReader(new FileReader("population.txt"));
words = r2.readLine();
while (words != null) {
max++;
populations[p] = Double.parseDouble(words);
words = r2.readLine();
p++;
}
r2.close();
} catch (FileNotFoundException e) {
System.out.println("File not found");
e.printStackTrace();
}
try {// reads in file for latitude
BufferedReader r3 = new BufferedReader(new FileReader("lat.txt"));
words2 = r3.readLine();
while (words2 != null) {
lats[l] = Double.parseDouble(words2);// reads in values for latitudes into array
words2 = r3.readLine();// reads the next line
l++;// i increments by 1 each time
}
r3.close();
} catch (FileNotFoundException e) {
System.out.println("File not found");
e.printStackTrace();
}
try {// reads in file for longitude
BufferedReader r4 = new BufferedReader(new FileReader("long.txt"));
words3 = r4.readLine();
while (words3 != null) {
longs[ll] = Double.parseDouble(words3);
words3 = r4.readLine();
ll++;
}
r4.close();
} catch (FileNotFoundException e) {
System.out.println("File not found");
e.printStackTrace();
}
double ogpop[] = populations.clone();// copies original population array before sorting
for (i = 0; i < max; i++) // sorts the populations from smallest to largest
{
for (j = 0; j < (max - 1); j++) {
if (populations[j] > populations[j + 1]) {
hold = populations[j + 1];
populations[j + 1] = populations[j];
populations[j] = hold;
}
}
}
for (i = 0; i < max; i++) {// checks for the largest city
if (ogpop[i] == populations[max - 1]) {
largest_num = ogpop[i];
largest_city = towns[i];
largest_lat = lats[i];
largest_long = longs[i];
break;
}
}
for (i = 0; i < max; i++) {// checks for the second largest city
if (ogpop[i] == populations[max - 2]) {
second = ogpop[i];
second_city = towns[i];
break;
}
}
for (i = 0; i < max; i++) {// finds distances between largest city and the other cities
dist[i] = Math.sqrt(Math.pow((largest_lat - lats[i]), 2) +
Math.pow((largest_long - longs[i]), 2));
}
double ogdist[] = dist.clone();// creates a copy of original array before sorting
for (i = 0; i < max; i++) // sorts the distances from smallest to largest
{
for (j = 0; j < (max - 1); j++) {
if (dist[j] > dist[j + 1]) {
hold = dist[j + 1];// keeps number temporarily
dist[j + 1] = dist[j];// pushes number to next section in the array
dist[j] = hold;
}
}
}
for (i = 0; i < max; i++) {// finds the town who's distance is the smallest
if (ogdist[i] == dist[1]) {
closest_city = towns[i];
closest = ogpop[i];
break;
}
}
for (i = 0; i < max; i++) {
// creates an array for all the distances between the largest city and the other cities
}
// prints out the 2 largest cities and the city closest to the largest city
System.out.println("U.S. cities Analytics");
System.out.println("------------------------");
System.out.println("Largest city:\t" + largest_city + " (population " +
(int) largest_num + ")");
System.out.println("Second Largest city:\t" + second_city + " (population "
+ (int) second + ")");
System.out.println("City closest to " + largest_city + ":\t" + closest_city +
" (population" + (int) closest + ")");
}
}