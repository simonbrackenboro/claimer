<html>
<head>
  <title>Web Frameworks Comparison</title>
  <link rel="stylesheet" type="text/css" href="/wro/all.css"/>
  <script type="text/javascript" src="/wro/all.js"></script>
</head>
<body ng-app="claimer" role="document">
<div id="loginModal" class="modal" tabindex="-1" role="dialog" aria-hidden="true" ng-controller="login">
  <div class="modal-dialog container-fluid">
    <div class="modal-content">
      <div class="modal-header">
        <h2 class="modal-title text-center">Please choose GitHub repository with optional password.</h2>
      </div>
      <div class="modal-body">
        <form class="form-horizontal container-fluid" name="loginForm">
          <div class="form-group">
            <label class="control-label sr-only" ng-class="{'has-error': loginForm.username.$invalid}">Username</label>
            <input type="text" class="form-control"
                   name="username" ng-model="username" required="true"/>
          </div>
          <div class="form-group">
            <label class="control-label sr-only">Password (optional)</label>
            <input type="password" class="form-control"
                   name="password" ng-model="password" required="false"/>
          </div>
          <div class="form-group">
            <div class="btn-group btn-group-justified">
              <a class="btn btn-primary" role="button" data-dismiss="modal" ng-click="login()"
                 ng-disabled="loginForm.url.$invalid">Select</a>
              <a class="btn btn-danger " role="button" data-dismiss="modal">Cancel</a>
            </div>
          </div>
        </form>
      </div>
    </div>
  </div>
</div>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
  <div class="container-fluid">
    <div class="claimer-container">
      <div class="claimer-left">
        <selectenvbranchcommit name="From"></selectenvbranchcommit>
      </div>
      <div class="claimer-center">
        <div class="btn-group">
          <button type="button" class="btn btn-default navbar-btn" data-toggle="modal" data-target="#loginModal">
            {{username || 'Login'}}
          </button>
        </div>
      </div>
      </button>
      <div class="claimer-right">
        <selectenvbranchcommit name="To"></selectenvbranchcommit>
      </div>
    </div>
  </div>
</nav>
<!--div class="container-fluid" role="main">
  <div class="fifty">
    <form><textarea id="FromText">Placeholder
    </textarea></form>
  </div>
  <div class="fifty">
    <form><textarea id="ToText">Placeholder
    </textarea></form>
  </div>
</div-->
<div id=view></div>
</div>
</body>
</html>