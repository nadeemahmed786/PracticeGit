// Generated by GraphWalker (http://www.graphwalker.org)
package org.graphwalker;

import org.graphwalker.java.annotation.Model;
import org.graphwalker.java.annotation.Vertex;
import org.graphwalker.java.annotation.Edge;

@Model(file = "org/graphwalker/Template.graphml")
public interface Template {

    @Vertex()
    void v_LoggedOut();

    @Vertex()
    void v_Dashboard();

    @Edge()
    void e_ValidLogin();

    @Edge()
    void e_InvalidLogin();

    @Edge()
    void e_StartBrowser();

    @Edge()
    void e_EnterBaseURL();

    @Vertex()
    void v_BaseURL();

    @Vertex()
    void v_BrowserStarted();
}
