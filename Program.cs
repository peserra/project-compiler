namespace projeto_compiler;

public class Program
{
  private static void Main()
  {
    try
    {
      var lexer = new Lexer("./input.izi");
      Token? token;
      do
      {
        token = lexer.NextToken();
        if (token is not null)
          Console.WriteLine(token);
      } while (token != null);
    }
    catch (LexicalException e)
    {
      Console.WriteLine($"Lexical exception{e.Message}");
    }
    catch (Exception e)
    {
      Console.WriteLine($"Unexpected exception {e.Message}");
    }
  }
}