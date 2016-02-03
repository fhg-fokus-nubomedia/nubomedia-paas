package org.project.openbaton.nubomedia.api.persistence;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.project.openbaton.nubomedia.api.messages.BuildingStatus;
import org.project.openbaton.nubomedia.api.openbaton.Flavor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import java.util.List;

/**
 * Created by maa on 28.09.15.
 */
@Entity
public class Application {

    @Id
    private String appID;
    private String appName;
    private String projectName;
    private String route;
    private String nsrID;
    private String gitURL;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Integer> targetPorts;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Integer> ports;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> protocols;
    private int replicasNumber;
    private String secretName;
    private Flavor flavor;
    private BuildingStatus status;
    @JsonIgnore private boolean resourceOK;

    public Application(String appID,Flavor flavor, String appName, String projectName, String route, String nsrID, String gitURL, List<Integer> targetPorts, List<Integer> ports, List<String> protocols, int replicasNumber, String secretName,boolean resourceOK) {
        this.appID = appID;
        this.flavor = flavor;
        this.appName = appName;
        this.projectName = projectName;
        this.route = route;
        this.nsrID = nsrID;
        this.gitURL = gitURL;
        this.targetPorts = targetPorts;

        if(ports == null){
            this.ports = targetPorts;
        }
        else{
            this.ports = ports;
        }

        this.protocols = protocols;
        this.replicasNumber = replicasNumber;
        this.secretName = secretName;
        this.status = BuildingStatus.CREATED;
        this.resourceOK = resourceOK;
    }

    public Application() {
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getNsrID() {
        return nsrID;
    }

    public void setNsrID(String nsrID) {
        this.nsrID = nsrID;
    }

    public String getGitURL() {
        return gitURL;
    }

    public void setGitURL(String gitURL) {
        this.gitURL = gitURL;
    }

    public int getReplicasNumber() {
        return replicasNumber;
    }

    public void setReplicasNumber(int replicasNumber) {
        this.replicasNumber = replicasNumber;
    }

    public String getSecretName() {
        return secretName;
    }

    public void setSecretName(String secretName) {
        this.secretName = secretName;
    }

    public Flavor getFlavor() {
        return flavor;
    }

    public void setFlavor(Flavor flavor) {
        this.flavor = flavor;
    }

    public String getAppID() {
        return appID;
    }

    public void setAppID(String appID) {
        this.appID = appID;
    }

    public BuildingStatus getStatus() {
        return status;
    }

    public void setStatus(BuildingStatus status) {
        this.status = status;
    }

    public boolean isResourceOK() {
        return resourceOK;
    }

    public void setResourceOK(boolean resourceOK) {
        this.resourceOK = resourceOK;
    }

    public List<Integer> getTargetPorts() {
        return targetPorts;
    }

    public void setTargetPorts(List<Integer> targetPorts) {
        this.targetPorts = targetPorts;
    }

    public List<Integer> getPorts() {
        return ports;
    }

    public void setPorts(List<Integer> ports) {
        this.ports = ports;
    }

    public List<String> getProtocols() {
        return protocols;
    }

    public void setProtocols(List<String> protocols) {
        this.protocols = protocols;
    }

    @Override
    public String toString(){
        return "Application with ID: " + appID  + "\n" +
                "Application name: " + appName + "\n" +
                "Project: " + projectName + "\n" +
                "Route: " + route + "\n" +
                "Git URL: " + gitURL;
    }
}
