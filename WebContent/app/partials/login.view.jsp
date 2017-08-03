<div style="font-family: Calibri;font-size: 1em;">
	Login Page
	<table>
		<tr>
			<td>Username:</td>
			<td><input type="text" ng-model="vm.userId"></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" ng-model="vm.secret"></td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: right;">
				<input type="button" ng-click="vm.login()" value="Login">
				<input type="button" ng-click="vm.reset()" value="Reset">
			</td>
		</tr>
	</table>
</div>