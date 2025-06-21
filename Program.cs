using System.Runtime.InteropServices;
using projeto_compiler;

public class Program
{
    private static void Main(string[] args)
    {
        try
        {
            var lexer = new Lexer("./input.izi");
            Token? token = null;
            do
            {
                token = lexer.NextToken();
                if (token is not null)
                    System.Console.WriteLine(token);
            } while (token != null);
        }
        catch (LexicalException e)
        {
            System.Console.WriteLine($"Lexical exception{e.Message}");
        }
        catch (Exception e)
        {
            System.Console.WriteLine($"Unexpected exception {e.Message}");
        }
    }
}
