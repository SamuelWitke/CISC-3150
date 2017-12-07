<pre>
Write a program that can handle plugins.

Your plugin interface is:

public abstract class myplugin{
        public void whoSaysHello(){}
        public void whoSaysBye(){}
}

Create two separate plugins from that abstract class. Place them in a
directory called plugin.

Your main program will search through the plugin directory looking for
plugin names, it'll then give the user an option whether they want to
execute the first plugin or the second plugin (print the plugin names on
the screen) And depending on the choice, it'll execute the two functions
in the chosen plugin.
</pre>
## Output
<pre>
Here is your list of plugins
0: IsThisSafeIdk
1: TotallyNotAVirus
Select the number of the plugin to run
1
Give me a sec while I hack your computer
...
All hacked
Hacking the goverment
...
All hacked
</pre>
