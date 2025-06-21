using System.Reflection.Metadata;
using System.Text;
using System.Text.Unicode;

namespace projeto_compiler;

enum States
{
    INITIAL,
    READING_ID,
    FINAL_ID,
    READING_NUM,
    FINAL_NUM,
    READING_OPERATOR,
    SIX,
    SEVEN,
    Error
}

public class Lexer
{
    public char[] Content { get; private set; }
    public int Position { get; private set; }
    private States State { get; set; }
    private StringBuilder TokenStringBuilder { get; set; }
    private string TokenText { get; set; }
    public Lexer(String fileName)
    {
        try
        {
            Content = File.ReadAllText(Path.GetFullPath(fileName), System.Text.Encoding.UTF8).ToCharArray();
            State = States.INITIAL;
            TokenStringBuilder = new StringBuilder();
            TokenText = string.Empty;
        }
        catch (System.Exception)
        {
            throw;
        }
    }

    // precisa trazer, a partir do automato, nosso modelo
    public Token? NextToken()
    {
        if (IsEOF())
            return null;

        while (true)
        {
            var currentChar = NextChar();
            switch (State)
            {
                case States.INITIAL:
                    if (IsChar(currentChar))
                    {
                        TokenStringBuilder.Append(currentChar);
                        State = States.READING_ID;
                    }
                    else if (IsDigit(currentChar))
                    {
                        TokenStringBuilder.Append(currentChar);
                        State = States.READING_NUM;
                    }
                    else if (IsIgnorable(currentChar))
                    {
                        State = States.INITIAL;
                    }
                    else if (IsOperator(currentChar))
                    {
                        TokenStringBuilder.Append(currentChar);
                        State = States.READING_OPERATOR;
                    }
                    else
                        throw new LexicalException($"Unrecognizable symbol {currentChar}");
                    break;
                case States.READING_ID:
                    if (IsChar(currentChar) || IsDigit(currentChar))
                    {
                        TokenStringBuilder.Append(currentChar);
                        State = States.READING_ID;
                    }
                    else if (IsIgnorable(currentChar) || IsOperator(currentChar))
                    {
                        State = States.FINAL_ID; // retorna tokenID
                    }
                    else
                    {
                        throw new LexicalException($"Malformed identifier {currentChar}");
                    }
                    break;
                case States.FINAL_ID:
                    ResetState();
                    return new Token(TokenTypes.IDENTIFIER, TokenText);
                case States.READING_NUM:
                    if (IsDigit(currentChar))
                    {
                        TokenStringBuilder.Append(currentChar);
                        State = States.READING_NUM;
                    }
                    else if (!IsChar(currentChar))
                    {
                        State = States.FINAL_NUM;
                    }
                    else
                    {
                        throw new LexicalException($"Unrecognized number {TokenStringBuilder.ToString() + currentChar}");
                    }
                    break;
                case States.FINAL_NUM:
                    ResetState();
                    return new Token(TokenTypes.NUMBER, TokenText);
                case States.READING_OPERATOR:
                    TokenStringBuilder.Append(currentChar);
                    ResetState();
                    return new Token(TokenTypes.OPERATOR, TokenText);
            }
        }
    }

    private bool IsDigit(char c)
    {
        return c >= '0' && c <= '9';
    }

    private bool IsChar(char c)
    {
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }

    private bool IsOperator(char c)
    {
        return c.Equals('=') || c.Equals('!') || c.Equals('<') || c.Equals('>');
    }

    private bool IsIgnorable(char c)
    {
        return c.Equals('\n') || c.Equals('\t') || c.Equals('\r') || c.Equals(' ');
    }

    private char NextChar()
    {
        return Content[Position++];
    }
    private bool IsEOF()
    {
        return Position.Equals(Content.Length);
    }

    private void BackOnePosition()
    {
        Position--;
    }

    private void ResetState()
    {
        State = States.INITIAL;
        TokenText = TokenStringBuilder.ToString();
        TokenStringBuilder.Clear();
        BackOnePosition();

    }

}
