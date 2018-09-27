# vke -- 0.9 (Build: 84a5513)

Command line interface for VMware Kubernetes Engine

- ```./vke account```  Commands to log in and show account info

  - ```./vke account show```  Show current logged in user info

  - ```./vke account login```  Log in to your organization
  To see your organization ID, log in to the VKE console, click on your name/org
	at the top of the page, and then click on the abbreviated organization ID to see
	the full organization ID. To get your refresh token, click on your name/org at the
 	top of the page, click My Account, and then click API Tokens. 

	Example: 
       vke account login -t fd2c1d78-9f00-4e30-8268-4ab8162080d \
                     -r 5fde5099-f329-4f1a-a580-fe359d919a7

    --organization value, -t value	specifies the VMware cloud services organization
    --refresh-token value, -r value	OAuth refresh token obtained from https://console.cloud.vmware.com
    --target value	sets the target
    --no-cert-check, -c	flag to avoid validating the server's certificate
    --proxyurl value, -p value	sets the proxy url for http client

- ```./vke organization```  Commands to manage organizations

  - ```./vke organization show```  Show detailed organization information
  Shows information related to an organization

   Example: 
       vke org show fd2c1d78-9f00-4e30-8268-4ab8162080d


  - ```./vke organization iam```  Sub-commands to manage access policies

    - ```./vke organization iam show```  Show the access policy for the organization
  Example: 
       vke org iam show fd2c1d78-9f00-4e30-8268-4ab8162080d 

    - ```./vke organization iam export```  Export the direct access policy to a file
  Example: 
       vke org iam export fd2c1d78-9f00-4e30-8268-4ab8162080d -o output.txt 
    --output value, -o value	Output file path

    - ```./vke organization iam import```  Import an access policy from a file
  Example: 
       vke org iam import fd2c1d78-9f00-4e30-8268-4ab8162080d -i input.txt 

    --input value, -i value	Input file path

    - ```./vke organization iam add```  Bind an identity to a role to grant permissions
  Bind an identity to a role on a organization to grant permissions. Role can be 
   'organization.edit' or 'organization.view'
   Example: 
       vke organization iam add fd2c1d78-9f00-4e30-8268-4ab8162080d \
                -s user1@account.local -r organization.edit
       vke organization iam add fd2c1d78-9f00-4e30-8268-4ab8162080d \
                -s group1 -r organization.view
    --subject value, -s value	name of the identity to bind (user or group)
    --role value, -r value	name of the role to bind

    - ```./vke organization iam remove```  Remove an identity from a role binding
  Remove an identity from a role binding on a organization. Role can be 
   'organization.edit' or 'organization.view'

   Example: 
       vke organization iam remove fd2c1d78-9f00-4e30-8268-4ab8162080d \
                -s user1@account.local -r organization.edit 
       vke organization iam remove fd2c1d78-9f00-4e30-8268-4ab8162080d \
                -s group1 -r organization.view

    --subject value, -s value	name of the identity to bind (user or group)
    --role value, -r value	name of the role to bind

- ```./vke info```  Commands to get information

  - ```./vke info region```  Commands to manage regions

    - ```./vke info region list```  List all regions

- ```./vke iam```  Commands to manage Identity and Access Management (IAM)

  - ```./vke iam role```  Manage Identity and Access Management (IAM) roles

    - ```./vke iam role list```  List role definitions
  List role definitions

  - ```./vke iam user```  Commands to manage users

    - ```./vke iam user show```  Show detailed user info
  Example: 
      vke user show user-name@organization


    - ```./vke iam user list```  List all users

  - ```./vke iam group```  Commands to manage groups

    - ```./vke iam group create```  Create a new group
  Only organization administrators can create a new group.

   Example:
      vke group create group1 --description 'Purpose of this group' 

    --description value, -d value	Description for group

    - ```./vke iam group delete```  Delete a group
  Only organization administrators can delete a group.

   Example:
      vke group delete group1

    - ```./vke iam group show```  Show detailed group information
  Example:
      vke group show group1

    - ```./vke iam group list```  List all groups

    - ```./vke iam group member```  Commands to manage group members

      - ```./vke iam group member add```  Add a member to a group
  Add a member to a group. Only organization administrators can create new group.

   Example:
      vke group member add group1 --member-name Bob 

    --member-name value, -m value	member name (user or group)

      - ```./vke iam group member remove```  Remove a member from a group
  Remove a member from a group. Only organization administrators can create new group.

   Example:
      vke group member remove group1 --member-name Bob 

    --member-name value, -m value	member name (user or group)

      - ```./vke iam group member list```  List all members in a group
  List all members in a group.

   Example:
      vke group member list group1 


- ```./vke folder```  Commands to manage folders

  - ```./vke folder create```  Create new folder
  Create new folder

   Example:
       vke folder create folder1 --display-name 'New Folder'

    --display-name value, -d value	sets the display name of the folder

  - ```./vke folder delete```  Delete a folder
  Delete a folder with specified name

   Example: 
       vke folder delete folder1 


  - ```./vke folder show```  Show information about a folder
  Shows details of a particular folder

   Example: 
       vke folder show folder1 


  - ```./vke folder get```  Show the current working folder
  Show current folder in use for vke

   Example: 
       vke folder get 


  - ```./vke folder set```  Set the current working folder
  Set the current folder used for all vke commands that needs folder

   Example: 
       vke folder set folder1 


  - ```./vke folder unset```  Unset the current folder
  Removes the current folder set in the config file

   Example: 
       vke folder unset 


  - ```./vke folder list```  List all folders
  Lists all folders in an organization

   Example: 
       vke folder list 


  - ```./vke folder iam```  Sub-commands to manage access policies

    - ```./vke folder iam show```  Show the direct and inherited access policies for the folder
  Example: 
      vke folder iam show folder1 


    - ```./vke folder iam export```  Export the direct access policy to a file
  Example: 
      vke folder iam export folder1 -o output.txt 

    --output value, -o value	Output file path

    - ```./vke folder iam import```  Import an access policy from a file
  Example: 
      vke folder iam import folder1 -i input.txt

    --input value, -i value	Input file path

    - ```./vke folder iam add```  Bind an identity to a role to grant permissions
  Bind an identity to a role on a folder to grant permissions. Role can be 
   'folder.edit' or 'folder.view'

   Example: 
       vke folder iam add folder1 -s user1@account.local \
              -r folder.edit
       vke folder iam add folder1 -s group1 -r folder.view

    --subject value, -s value	name of the identity to bind (user or group)
    --role value, -r value	name of the role to bind

    - ```./vke folder iam remove```  Remove an identity from a role binding
  Remove an identity from a role binding on a folder. Role can be 
   'folder.edit', 'folder.view' or use '*' to remove all existing roles

   Example: 
       vke folder iam remove folder1 -s user1@account.local \
              -r folder.edit 
       vke folder iam remove folder1 -s group1 -r folder.view

    --subject value, -s value	name of the identity to bind (user or group)
    --role value, -r value	name of the role to bind

- ```./vke project```  Commands to manage global projects

  - ```./vke project create```  Create new project within a folder
  Create new project

   Example:
       vke project create project1

    --display-name value, -d value	sets the display name of the project
    --folder value, -f value	specify the current working folder

  - ```./vke project delete```  Delete project
  Delete an existing project

   Example:
       vke project delete project1

    --folder value, -f value	specify the current working folder

  - ```./vke project show```  Show information about project
  Show project info

   Example:
       vke project show project1

    --folder value, -f value	specify the current working folder

  - ```./vke project get```  Show the current working project
  Show current project in use for vke

   Example:
       vke project get 


  - ```./vke project set```  Set the current working project
  Set the current project used for all vke 

   Example:
       vke project set project1 


    --folder value, -f value	specify the current working folder

  - ```./vke project unset```  Unset the current project
  Unset the current project set in the config file

   Example: 
       vke project unset 


  - ```./vke project list```  List all projects
  List all project within a folder

   Example:
       vke project list

    --folder value, -f value	specify the current working folder

  - ```./vke project iam```  Sub-commands to manage access policies

    - ```./vke project iam show```  Show the direct and inherited access policies for the project
  Example: 
      vke project iam show project1 

    --folder value, -f value	specify the current working folder

    - ```./vke project iam export```  Export the direct access policy to a file
  Example: 
      vke project iam export project1 -o file.txt 

    --output value, -o value	Output file path
    --folder value, -f value	specify the current working folder

    - ```./vke project iam import```  Import an access policy from a file
  Example: 
      vke project iam import project1 -i file.txt 

    --input value, -i value	Input file path
    --folder value, -f value	specify the current working folder

    - ```./vke project iam add```  Bind an identity to a role to grant permissions
  Bind an identity to a role on a project to grant permissions. Role can be 
   'project.edit' or 'project.view'

   Example: 
       vke project iam add project1 -s user1@account.local -r project.edit
       vke project iam add project1 -s group1 -r project.view

    --subject value, -s value	name of the identity to bind (user or group)
    --role value, -r value	name of the role to bind
    --folder value, -f value	specify the current working folder

    - ```./vke project iam remove```  Remove an identity from a role binding
  Remove an identity from a role binding on a project. Role can be 
   'project.edit', 'project.view' or use '*' to remove all existing roles

   Example: 
       vke project iam remove project1 -s user1@account.local -r project.edit 
       vke project iam remove project1 -s group1 -r project.view

    --subject value, -s value	name of the identity to bind (user or group)
    --role value, -r value	name of the role to bind
    --folder value, -f value	specify the current working folder

- ```./vke cluster```  Commands to manage clusters

  - ```./vke cluster templates```  Commands to list template

    - ```./vke cluster templates list```  List Kubernetes Smart Cluster templates

  - ```./vke cluster versions```  Commands to list Kubernetes versions

    - ```./vke cluster versions list```  List available Kubernetes versions
  Lists available Kubernetes versions for a specific region

   Example:
       vke cluster versions list --region us-west-2 

    --region value, -r value	Region name (required)

  - ```./vke cluster create```  Create a new cluster
  Create a new Kubernetes cluster. 

   Example: 
   vke cluster create -n TestCluster -v 1.7.5\
      --region us-west-2

    --name value, -n value	Cluster name
    --service-level value, -l value	DEVELOPER: No HA for etcd or masters. ENTERPRISE: etcd and masters 
		are deployed in HA fashion (multiple nodes & AZs)
    --display-name value, -d value	The friendly name of the cluster which is used for display
    --network-tenancy value	SHARED: Clusters will share Tenant's network in the region. 
DEDICATED: Clusters will have their own networks
    --cluster-network value	CIDR representation of the cluster network (optional). 
		If not specified, the default value is '10.1.0.0/16'
    --pod-network value	CIDR representation of the pod network (optional). 
		If not specified, the default value is '10.2.0.0/16'
    --service-network value	CIDR representation of the service network (optional). 
		If not specified, the default value is '10.0.0.0/24'
    --region value, -r value	Region where cluster should be created
    --version value, -v value	Kubernetes version that should be created
    --template value, -t value	Kubernetes smart cluster template name
    --privilegedMode	Creates a cluster with privileged mode capabilities.
		What is privileged mode?
		A collection of root-equivalent functionalities available for all pods running 
		on the cluster. Privileged mode includes the following Kubernetes features: 
		hostPath, hostPID, hostNetwork, hostIPC, privileged pods and all linux capabilities.
		WARNING: By selecting "privileged mode", users enable a set of root-equivalent 
		functionalities for pods running on the cluster. Applications with privileged
		mode enabled have two risks. First, an application may modify the underlying OS 
		in ways that may result in an unstable node or cluster and ultimately result in 
		the inability for the VKE service to fully manage the smart cluster. Second, if  
		an application is compromised by a malicious attacker, it is easier to spread 
		the attack to other applications in the same cluster.
    --force	This option will force creating a cluster with privileged mode capabilities.
    --folder value, -f value	specify the current working folder
    --project value, --pr value	specify the current working project

  - ```./vke cluster show```  Show information about a cluster 
  List the cluster's name, state, type, workerCount 
   and all the extended properties. 

   Example: 
      vke cluster show TestCluster

    --perf, -p	Cluster Creation Perf Report
    --folder value, -f value	specify the current working folder
    --project value, --pr value	specify the current working project

  - ```./vke cluster show-health```  Show health information about a cluster 
  List the cluster's overall health, message and health details

   Example: 
      vke cluster show-health TestCluster

    --folder value, -f value	specify the current working folder
    --project value, --pr value	specify the current working project

  - ```./vke cluster list```  List clusters
  List all clusters in the current tenant. 

   Example: 
      vke cluster list

    --folder value, -f value	specify the current working folder
    --project value, --pr value	specify the current working project

  - ```./vke cluster rename```  Change the display name of a cluster
  Example: 
   vke cluster rename TestCluster 'New Display Name'

    --folder value, -f value	specify the current working folder
    --project value, --pr value	specify the current working project

  - ```./vke cluster delete```  Delete a cluster
  Delete a cluster. WARNING: All running applications will be forcibly stopped. 

   Example: 
      vke cluster delete TestCluster

    --folder value, -f value	specify the current working folder
    --project value, --pr value	specify the current working project

  - ```./vke cluster upgrade```  Upgrade the Kubernetes version your cluster is running
  Example: 
      vke cluster upgrade TestCluster -v 1.7.5

    --version value, -v value	version
    --upgradev2, --v2	This defines if new upgrade workflow will execute or not
    --folder value, -f value	specify the current working folder
    --project value, --pr value	specify the current working project

  - ```./vke cluster maintain```  Start cluster maintenance
  Performs maintenance on the cluster, including re-creation of failed master nodes. 
   Please note that this should normally not be needed, except in unusual situations, 
   because maintenance is automatically performed. 

   Example: 
      vke cluster maintain TestCluster

    --folder value, -f value	specify the current working folder
    --project value, --pr value	specify the current working project

  - ```./vke cluster get-kubectl-auth```  Generate the kubectl command for authentication
  Generate the kubectl (Kubernetes command line client) configuration. There are two options. 
   1. Run vke cluster get-kubectl-auth TestCluster with --configfile option 
   to create a new Kubernetes config. You can move the created file to ~/.kube/config (Mac OS X and Linux) to replace 
   your default config. 
   2. Run vke cluster get-kubectl-auth TestCluster without the --configfile 
   option. This will print commands that you can copy and paste to modify your Kubernetes configuration. 

   Example: 
      vke cluster get-kubectl-auth TestCluster -u user1@org-id -p password -cf config-file.txt

    --username value, -u value	Username for login
    --configfile value, --cf value	specifies the filename in which the user wants the kubectl configuration to be generated
    --password value, -p value	Password for login
    --idp value, -i value	specifies the identity provider; supported providers are csp (default) and lightwave
    --folder value, -f value	specify the current working folder
    --project value, --pr value	specify the current working project

  - ```./vke cluster merge-kubectl-auth```  Configure kubectl for authentication
  Modify your default kubectl configuration file to allow access to your cluster 

   Example: 
      vke cluster merge-kubectl-auth TestCluster

    --username value, -u value	Username for login
    --password value, -p value	Password for login
    --idp value, -i value	specifies the identity provider; supported providers are csp (default) and lightwave
    --embed-ca, -e	Embed CA cert into kubectl config
    --folder value, -f value	specify the current working folder
    --project value, --pr value	specify the current working project

  - ```./vke cluster auth```  Sub-commands to manage kubectl authentication

    - ```./vke cluster auth setup```  Configure kubectl to allow communication with your cluster
  Modify your default kubectl configuration file to allow access to your cluster 

   Example: 
      vke cluster auth setup TestCluster

    --username value, -u value	Username for login
    --password value, -p value	Password for login
    --idp value, -i value	specifies the identity provider; supported providers are csp (default) and lightwave
    --embed-ca, -e	Embed CA cert into kubectl config
    --folder value, -f value	specify the current working folder
    --project value, --pr value	specify the current working project

    - ```./vke cluster auth delete```  Remove the configuration from kubectl config file for your cluster
  Remove the entries from your default kubectl configuration file for your cluster 

   Example: 
      vke cluster auth delete TestCluster

    --folder value, -f value	specify the current working folder
    --project value, --pr value	specify the current working project

  - ```./vke cluster iam```  Sub-commands to manage access policies

    - ```./vke cluster iam show```  Show the direct and inherited access policies for the cluster
  Example: 
       vke cluster iam show TestCluster 

    --folder value, -f value	specify the current working folder
    --project value, --pr value	specify the current working project

    - ```./vke cluster iam export```  Export the direct access policy to a file
  Example: 
       vke cluster iam export TestCluster -o file.txt 

    --output value, -o value	Output file path
    --folder value, -f value	specify the current working folder
    --project value, --pr value	specify the current working project

    - ```./vke cluster iam import```  Import an access policy from a file
  Example: 
       vke cluster iam import TestCluster -i file.txt 

    --input value, -i value	Input file path
    --folder value, -f value	specify the current working folder
    --project value, --pr value	specify the current working project

    - ```./vke cluster iam add```  Bind an identity to a role to grant permissions
  Bind an identity to a role on a cluster to grant permissions. Role can be 'smartcluster.admin', 
   'smartcluster.edit' or 'smartcluster.view'

   Example: 
       vke cluster iam add TestCluster -s user1@account.local \
             -r smartcluster.edit
       vke cluster iam add TestCluster -s group1 -r smartcluster.view

    --subject value, -s value	name of the identity to bind (user or group)
    --role value, -r value	name of the role to bind
    --folder value, -f value	specify the current working folder
    --project value, --pr value	specify the current working project

    - ```./vke cluster iam remove```  Remove an identity from a role binding
  Remove an identity from a role binding on a cluster. Role can be 'smartcluster.admin',
   'smartcluster.edit', 'smartcluster.view' or use '*' to remove all existing roles.

   Example: 
       vke cluster iam remove TestCluster -s user1@account.local \
              -r smartcluster.edit 
       vke cluster iam remove TestCluster -s group1 -r smartcluster.view

    --subject value, -s value	name of the identity to bind (user or group)
    --role value, -r value	name of the role to bind
    --folder value, -f value	specify the current working folder
    --project value, --pr value	specify the current working project

  - ```./vke cluster namespace```  Commands to manage namespaces

    - ```./vke cluster namespace create```  Create new namespace
  Example:
       vke namespace create cluster1 namespace1

    --folder value, -f value	specify the current working folder
    --project value, --pr value	specify the current working project

    - ```./vke cluster namespace delete```  Delete a namespace
  Delete a namespace with specified name

   Example:
       vke namespace delete cluster1 namespace1

    --folder value, -f value	specify the current working folder
    --project value, --pr value	specify the current working project

    - ```./vke cluster namespace show```  Show information about a namespace
  Shows details related to a namespace

   Example:
       vke namespace show cluster1 namespace1

    --folder value, -f value	specify the current working folder
    --project value, --pr value	specify the current working project

    - ```./vke cluster namespace list```  List all namespaces

    --folder value, -f value	specify the current working folder
    --project value, --pr value	specify the current working project

    - ```./vke cluster namespace iam```  Sub-commands to manage access policies

      - ```./vke cluster namespace iam show```  Show the direct and inherited access policies for the namespace
  Example: 
       vke namespace iam show cluster1 namespace1 

    --folder value, -f value	specify the current working folder
    --project value, --pr value	specify the current working project

      - ```./vke cluster namespace iam export```  Export the direct access policy to a file
  Example: 
       vke namespace iam export cluster1 namespace1 -o file.txt 

    --output value, -o value	Output file path
    --folder value, -f value	specify the current working folder
    --project value, --pr value	specify the current working project

      - ```./vke cluster namespace iam import```  Import an access policy from a file
  Example: 
       vke namespace iam import cluster1 namespace1 -i file.txt 

    --input value, -i value	Input file path
    --folder value, -f value	specify the current working folder
    --project value, --pr value	specify the current working project

      - ```./vke cluster namespace iam add```  Bind an identity to a role to grant permissions
  Bind an identity to a role on a namespace to grant permissions. Role can be 'namespace.admin', 
   'namespace.edit' or 'namespace.view'
   Example: 
       vke namespace iam add <cluster-name> <namespace> \
       -s user1@account.local -r namespace.edit
       vke namespace iam add <cluster-name> <namespace> \
       -s group1 -r namespace.view

    --subject value, -s value	name of the identity to bind (user or group)
    --role value, -r value	name of the role to bind
    --folder value, -f value	specify the current working folder
    --project value, --pr value	specify the current working project

      - ```./vke cluster namespace iam remove```  Remove an identity from a role binding
  Remove an identity from a role binding on a namespace. Role can be 'namespace.admin', 
   'namespace.edit', 'namespace.view' or use '*' to remove all existing roles
   Example: 
       vke namespace iam remove <cluster-name> <namespace> \
       -s user1@account.local -r namespace.edit 
       vke namespace iam remove <cluster-name> <namespace> \
       -s group1 -r namespace.view

    --subject value, -s value	name of the identity to bind (user or group)
    --role value, -r value	name of the role to bind
    --folder value, -f value	specify the current working folder
    --project value, --pr value	specify the current working project

  - ```./vke cluster peering```  Commands to manage peerings

    - ```./vke cluster peering create```  Create new peering
  Create new peering. 
   Example:
       vke cluster peering create -c <cluster-name> -n <peering-name> \
      --customer-account-id <customer-account-id> --customer-network-id <customer-network-id>  \
      --customer-network-cidr <customer-network-cidr> --customer-network-region <network-region>

    --cluster-name value, -c value	Cluster name
    --name value, -n value	Peering name
    --customer-account-id value	Customer account id
    --customer-network-id value	Customer network id
    --customer-network-cidr value	Customer network cidr
    --customer-network-region value	Customer network region
    --folder value, -f value	specify the current working folder
    --project value, --pr value	specify the current working project

    - ```./vke cluster peering delete```  Delete a peering
  Delete a peering. 
   Example:
       vke cluster peering delete <cluster-name> <peering-id>

    --folder value, -f value	specify the current working folder
    --project value, --pr value	specify the current working project

    - ```./vke cluster peering rename```  Rename a peering
  Update name of a peering. 
   Example:
       vke cluster peering rename <cluster-name> <peering-id> <new-peering-name>

    --folder value, -f value	specify the current working folder
    --project value, --pr value	specify the current working project

    - ```./vke cluster peering show```  Show information about a peering
  Show information of a peering. 
   Example:
       vke cluster peering show <cluster-name> <peering-id>

    --folder value, -f value	specify the current working folder
    --project value, --pr value	specify the current working project

    - ```./vke cluster peering list```  List all peerings for a cluster
  List all peerings of a cluster. 
   Example:
       vke cluster peering list <cluster-name>

    --folder value, -f value	specify the current working folder
    --project value, --pr value	specify the current working project

- ```./vke documentation```  prints the CLI documentation

- ```./vke help```  Shows a list of commands or help for one command

Global Flags

--non-interactive, -n	trigger for non-interactive mode (scripting)
--log-file value, -l value	write logging information into a logfile at the specified path
--output value, -o value	the output format can be any of the following values ["json"]
--detail, -d	print the current target, user, Organization and project
--help, -h	show help
--version, -v	print the version
