stage ('build')
{ 
	parallel build:{
		node {
			sh ('echo building stuff > file.txt');
			archiveArtifacts artifacts: 'file.txt', fingerprint: true, onlyIfSuccessful: true
		}
	},
	sonar:{
		node {
			sh ('echo Sonar');
		}
	}
}

//stage('Deploy approval')
//{
//	input 'Deploy to prod?'
//}
node
{
	stage ('deploy')
	{
		sh ('echo deploy')
	}
}
